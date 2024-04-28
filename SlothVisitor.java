import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class SlothVisitor extends SlothParserBaseVisitor<SlothValue> {

    Scanner scnr = new Scanner(System.in);
    HashMap<String, SlothValue> symbols = new HashMap<>();
    Stack<HashMap<String, SlothValue>> stack = new Stack<>();
    HashMap<String, SlothParser.FunctionDefContext> functions = new HashMap<>();

    public static class MultipleMethodDeclaration extends RuntimeException {

        public MultipleMethodDeclaration(){};
        public MultipleMethodDeclaration(String errMessage, Throwable err) {
            super(errMessage, err);
        }
    }

    public class FunctionReturn extends RuntimeException {
        SlothValue val;
        FunctionReturn(SlothValue val) {
            this.val = val;
        }

        SlothValue getVal() {
            return val;
        }
    }

    @Override
    public SlothValue visitProgram(SlothParser.ProgramContext ctx) {
        for (SlothParser.StatementContext statement : ctx.statement()) {
            visit(statement);
        }
        return null;
    }

    @Override
    public SlothValue visitAssign(SlothParser.AssignContext ctx) {
        String id = ctx.ID().getText();
        if (!stack.isEmpty()) {
            HashMap<String, SlothValue> scope = stack.peek();
            if (ctx.LBRACK() != null) {
                SlothValue left = visit(ctx.expression(0));
                SlothValue right = visit(ctx.expression(1));
                if (scope.containsKey(id)) {
                    ArrayList<SlothValue> result = scope.get(id).toArray();
                    result.set(left.toInt(), right);
                    scope.replace(id, new SlothValue(result));
                } else {
                    ArrayList<SlothValue> result = new ArrayList<>();
                    result.set(left.toInt(), right);
                    scope.put(id, new SlothValue(result));
                }
            } else {
                SlothValue val = visit(ctx.expression(0));
                if (scope.containsKey(id)) {
                    scope.replace(id, val);
                } else {
                    scope.put(id, val);
                }
            }
        } else {
            if (ctx.LBRACK() != null) {
                SlothValue left = visit(ctx.expression(0));
                SlothValue right = visit(ctx.expression(1));
                if (symbols.containsKey(id)) {
                    ArrayList<SlothValue> result = symbols.get(id).toArray();
                    result.set(left.toInt(), right);
                    symbols.replace(id, new SlothValue(result));
                } else {
                    ArrayList<SlothValue> result = new ArrayList<>();
                    result.set(left.toInt(), right);
                    symbols.put(id, new SlothValue(result));
                }
            } else {
                SlothValue val = visit(ctx.expression(0));
                if (symbols.containsKey(id)) {
                    symbols.replace(id, val);
                } else {
                    symbols.put(id, val);
                }
            }
        }
        return null;
    }

    @Override
    public SlothValue visitIf(SlothParser.IfContext ctx) {
        if (visit(ctx.expression()).toBool()) {
            visit(ctx.statement());
        }
        return null;
    }

    @Override
    public SlothValue visitIfelse(SlothParser.IfelseContext ctx) {
        if (visit(ctx.expression()).toBool()) {
            visit(ctx.statement(0));
        } else {
            visit(ctx.statement(1));
        }
        return null;
    }

    @Override
    public SlothValue visitWhile(SlothParser.WhileContext ctx) {
        while (visit(ctx.expression()).toBool()) {
            visit(ctx.statement());
        }
        return null;
    }

    @Override
    public SlothValue visitPrint(SlothParser.PrintContext ctx) {
        SlothValue expr = visit(ctx.expression());
        if (expr.getType() == SlothType.STRING) {
            System.out.print(expr.toString().replace("\"",""));
        } else {
            System.out.print(expr);
        }
        return null;
    }

    @Override
    public SlothValue visitPrintln(SlothParser.PrintlnContext ctx) {
        SlothValue expr = visit(ctx.expression());
        if (expr.getType() == SlothType.STRING) {
            System.out.println(expr.toString().replace("\"",""));
        } else {
            System.out.println(expr);
        }
        return null;
    }

    @Override
    public SlothValue visitBegin(SlothParser.BeginContext ctx) {
        for (SlothParser.StatementContext statement : ctx.statement()) {
            visit(statement);
        }
        return null;
    }

    @Override
    public SlothValue visitFunctionDef(SlothParser.FunctionDefContext ctx) {
        String id = ctx.ID(0).getText();
        try {
            if (!functions.containsKey(id)) {
                functions.put(id, ctx);
            } else {
                throw new MultipleMethodDeclaration();
            }
        } catch(MultipleMethodDeclaration e) {
            throw new MultipleMethodDeclaration(id + " has multiple method declarations", e);
        }
        return null;
    }

    @Override
    public SlothValue visitReturn(SlothParser.ReturnContext ctx) {
        SlothValue val;
        if (ctx.expression() != null) {
            val = visit(ctx.expression());
        } else {
            val = null;
        }
        throw new FunctionReturn(val);
    }

    @Override
    public SlothValue visitFuncCallStmt(SlothParser.FuncCallStmtContext ctx) {
        String id = ctx.ID().getText();
        SlothParser.FunctionDefContext fn;
        SlothValue val;
        SlothValue retval = null;
        if (functions.containsKey(id)) {
            fn = functions.get(id);
        } else {
            return null;
        }
        HashMap<String, SlothValue> funcSymbols = new HashMap<>();
        int i = 1;
        for (SlothParser.ExpressionContext expression : ctx.expression()) {
            val = visit(expression);
            funcSymbols.put(fn.ID(i).getText(), val);
            i++;
        }
        stack.push(funcSymbols);
        try {
            for (SlothParser.StatementContext statement : fn.statement()) {
                visit(statement);
            }
        } catch(FunctionReturn e) {
            retval = e.getVal();
        }
        stack.pop();
        return retval;
    }

    @Override
    public SlothValue visitFuncCallExpr(SlothParser.FuncCallExprContext ctx) {
        String id = ctx.ID().getText();
        SlothParser.FunctionDefContext fn;
        SlothValue val;
        SlothValue retval = null;
        if (functions.containsKey(id)) {
            fn = functions.get(id);
        } else {
            return null;
        }
        HashMap<String, SlothValue> funcSymbols = new HashMap<>();
        int i = 1;
        for (SlothParser.ExpressionContext expression : ctx.expression()) {
            val = visit(expression);
            funcSymbols.put(fn.ID(i).getText(), val);
            i++;
        }
        stack.push(funcSymbols);
        try {
            for (SlothParser.StatementContext statement : fn.statement()) {
                visit(statement);
            }
        } catch(FunctionReturn e) {
            retval = e.getVal();
        }
        stack.pop();
        return retval;
    }

    @Override
    public SlothValue visitTimesdiv(SlothParser.TimesdivContext ctx) {
        SlothValue left = visit(ctx.expression(0));
        SlothValue right = visit(ctx.expression(1));

        if (left.getType() == SlothType.INT && right.getType() == SlothType.INT) {
            if (ctx.op.getType() == SlothParser.TIMES) {
                return new SlothValue(left.toInt() * right.toInt());
            } else {
                return new SlothValue(left.toInt() / right.toInt());
            }
        } else {
            if (ctx.op.getType() == SlothParser.TIMES) {
                return new SlothValue(left.toReal() * right.toReal());
            } else {
                return new SlothValue(left.toReal() / right.toReal());
            }
        }
    }

    @Override
    public SlothValue visitPlusminus(SlothParser.PlusminusContext ctx) {
        SlothValue left = visit(ctx.expression(0));
        SlothValue right = visit(ctx.expression(1));

        if (left.getType() == SlothType.INT && right.getType() == SlothType.INT) {
            if (ctx.op.getType() == SlothParser.PLUS) {
                return new SlothValue(left.toInt() + right.toInt());
            } else {
                return new SlothValue(left.toInt() - right.toInt());
            }
        } else if (left.getType() == SlothType.STRING || right.getType() == SlothType.STRING) {
            if (ctx.op.getType() == SlothParser.PLUS) {
                return new SlothValue(left.toString().concat(right.toString()));
            } else {
                try {
                    throw new Exception("Invalid Operation on String");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        } else if (left.getType() == SlothType.ARRAY || right.getType() == SlothType.ARRAY){
            ArrayList<SlothValue> first = left.toArray();
            ArrayList<SlothValue> second = right.toArray();
            ArrayList<SlothValue> result = new ArrayList<>();
            result.addAll(first);
            result.addAll(second);
            return new SlothValue(result);
        } else {
            if (ctx.op.getType() == SlothParser.PLUS) {
                return new SlothValue(left.toReal() + right.toReal());
            } else {
                return new SlothValue(left.toReal() - right.toReal());
            }
        }
        return null;
    }

    @Override
    public SlothValue visitNot(SlothParser.NotContext ctx) {
        return new SlothValue(!visit(ctx.expression()).toBool());
    }

    @Override
    public SlothValue visitCompare(SlothParser.CompareContext ctx) {
        SlothValue left = visit(ctx.expression(0));
        SlothValue right = visit(ctx.expression(1));

        if (left.getType() == SlothType.INT && right.getType() == SlothType.INT) {
            if (ctx.op.getType() == SlothParser.LTHAN) {
                return new SlothValue(left.toInt() < right.toInt());
            } else if (ctx.op.getType() == SlothParser.LTEQ) {
                return new SlothValue(left.toInt() <= right.toInt());
            } else if (ctx.op.getType() == SlothParser.GTHAN) {
                return new SlothValue(left.toInt() > right.toInt());
            } else if (ctx.op.getType() == SlothParser.GTEQ) {
                return new SlothValue(left.toInt() >= right.toInt());
            } else if (ctx.op.getType() == SlothParser.EQUAL) {
                return new SlothValue(left.toInt() == right.toInt());
            } else {
                return new SlothValue(left.toInt() != right.toInt());
            }
        } else if(left.getType() == SlothType.STRING && right.getType() == SlothType.STRING) {
            if (ctx.op.getType() == SlothParser.EQUAL) {
                return new SlothValue(left.toString().replace("\"", "").equals(right.toString().replace("\"", "")));
            }
        } else {
            if (ctx.op.getType() == SlothParser.LTHAN) {
                return new SlothValue(left.toReal() < right.toReal());
            } else if (ctx.op.getType() == SlothParser.LTEQ) {
                return new SlothValue(left.toReal() <= right.toReal());
            } else if (ctx.op.getType() == SlothParser.GTHAN) {
                return new SlothValue(left.toReal() > right.toReal());
            } else if (ctx.op.getType() == SlothParser.GTEQ) {
                return new SlothValue(left.toReal() >= right.toReal());
            } else if (ctx.op.getType() == SlothParser.EQUAL) {
                return new SlothValue(left.toReal() == right.toReal());
            } else {
                return new SlothValue(left.toReal() != right.toReal());
            }
        }
        return null;
    }

    @Override
    public SlothValue visitOr(SlothParser.OrContext ctx) {
        SlothValue left = visit(ctx.expression(0));
        SlothValue right = visit(ctx.expression(1));

        if (left.toBool()) {
            return new SlothValue(true);
        } else if (right.toBool()) {
            return new SlothValue(true);
        } else {
            return new SlothValue(false);
        }
    }

    @Override
    public SlothValue visitAnd(SlothParser.AndContext ctx) {
        SlothValue left = visit(ctx.expression(0));
        SlothValue right = visit(ctx.expression(1));

        if (!left.toBool()) {
            return new SlothValue(false);
        } else if (!right.toBool()) {
            return new SlothValue(false);
        } else {
            return new SlothValue(true);
        }
    }

    @Override
    public SlothValue visitArraysub(SlothParser.ArraysubContext ctx) {
        SlothValue expr = visit(ctx.expression());
        int index = expr.toInt();
        String id = ctx.ID().getText();
        ArrayList<SlothValue> val;
        if (!stack.isEmpty()) {
            HashMap<String, SlothValue> scope = stack.peek();
            if (scope.containsKey(id)) {
                val = scope.get(id).toArray();
                return val.get(index);
            } else if (symbols.containsKey(id)) {
                val = symbols.get(id).toArray();
                return val.get(index);
            } else {
                return null;
            }
        }
        if (symbols.containsKey(id)) {
            val = symbols.get(id).toArray();
            return val.get(index);
        } else {
            return null;
        }
    }

    @Override
    public SlothValue visitLength(SlothParser.LengthContext ctx) {
        String id = ctx.ID().getText();
        ArrayList<SlothValue> array;
        String str;
        if (!stack.isEmpty()) {
            HashMap<String, SlothValue> scope = stack.peek();
            if (scope.containsKey(id)) {
                if (scope.get(id).getType() == SlothType.ARRAY) {
                    array = scope.get(id).toArray();
                    return new SlothValue(array.size());
                } else if (scope.get(id).getType() == SlothType.STRING) {
                    str = scope.get(id).toString();
                    return new SlothValue(str.length());
                } else {
                    return null;
                }
            } else if (symbols.containsKey(id)) {
                if (symbols.get(id).getType() == SlothType.ARRAY) {
                    array = symbols.get(id).toArray();
                    return new SlothValue(array.size());
                } else if (symbols.get(id).getType() == SlothType.STRING) {
                    str = symbols.get(id).toString();
                    return new SlothValue(str.length());
                }
            } else {
                return null;
            }
        }
        else if (symbols.containsKey(id)) {
            if (symbols.get(id).getType() == SlothType.ARRAY) {
                array = symbols.get(id).toArray();
                return new SlothValue(array.size());
            } else if (symbols.get(id).getType() == SlothType.STRING) {
                str = symbols.get(id).toString();
                return new SlothValue(str.length());
            } else {
                return null;
            }
        }
        return null;
    }

    @Override
    public SlothValue visitTrue(SlothParser.TrueContext ctx) {
        return new SlothValue(true);
    }

    @Override
    public SlothValue visitFalse(SlothParser.FalseContext ctx) {
        return new SlothValue(false);
    }

    @Override
    public SlothValue visitRealval(SlothParser.RealvalContext ctx) {
        return new SlothValue(Double.parseDouble(ctx.REALVAL().getText()));
    }

    @Override
    public SlothValue visitIntval(SlothParser.IntvalContext ctx) {
        return new SlothValue(Integer.parseInt(ctx.INTVAL().getText()));
    }

    @Override
    public SlothValue visitStrval(SlothParser.StrvalContext ctx) {
        return new SlothValue(ctx.STRINGVAL().getText());
    }

    @Override
    public SlothValue visitParens(SlothParser.ParensContext ctx) {
        return visit(ctx.expression());
    }

    @Override
    public SlothValue visitId(SlothParser.IdContext ctx) {
        String id = ctx.ID().getText();
        if (!stack.isEmpty()) {
            HashMap<String, SlothValue> scope = stack.peek();
            if (scope.containsKey(id)) {
                return scope.get(id);
            }
            else if (symbols.containsKey(id)) {
                return symbols.get(id);
            } else {
                return null;
            }
        } else if (symbols.containsKey(id)) {
            return symbols.get(id);
        } else {
            return null;
        }
    }

    @Override
    public SlothValue visitReadint(SlothParser.ReadintContext ctx) {
        int val = scnr.nextInt();
        return new SlothValue(val);
    }

    @Override
    public SlothValue visitReadreal(SlothParser.ReadrealContext ctx) {
        double val = scnr.nextDouble();
        return new SlothValue(val);
    }

    @Override
    public SlothValue visitReadbool(SlothParser.ReadboolContext ctx) {
        boolean val = scnr.nextBoolean();
        return new SlothValue(val);
    }

    @Override
    public SlothValue visitReadstr(SlothParser.ReadstrContext ctx) {
        String val = scnr.next();
        return new SlothValue(val);
    }

    @Override
    public SlothValue visitLitarray(SlothParser.LitarrayContext ctx) {
        ArrayList<SlothValue> array = new ArrayList<>();
        for (SlothParser.ExpressionContext expression : ctx.expression()) {
            SlothValue expr = visit(expression);
            if (expr.getType() == SlothType.ARRAY) {
                ArrayList<SlothValue> inArray = expr.toArray();
                array.addAll(inArray);
            } else {
                array.add(expr);
            }
        }
        return new SlothValue(array);
    }
}
