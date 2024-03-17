import java.io.*;
import java.util.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class SlothVisitor extends SlothParserBaseVisitor<SlothValue> {

    Scanner scnr = new Scanner(System.in);
    HashMap<String, SlothValue> symbols;

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
        SlothValue val = visit(ctx.expression());
        if (symbols.containsKey(id)) {
            symbols.replace(id, val);
        } else {
            symbols.put(id, val);
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
        System.out.print(expr);
        return null;
    }

    @Override
    public SlothValue visitPrintln(SlothParser.PrintlnContext ctx) {
        SlothValue expr = visit(ctx.expression());
        System.out.println(expr);
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
        } else {
            if (ctx.op.getType() == SlothParser.PLUS) {
                return new SlothValue(left.toReal() + right.toReal());
            } else {
                return new SlothValue(left.toReal() - right.toReal());
            }
        }
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
    }

    // @Override
    // public SlothValue visitJustterm(SlothParser.JusttermContext ctx) {
        // return (visit(ctx.term()));
    // }

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
        return symbols.get(id);
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
}