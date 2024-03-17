// Generated from SlothParser.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SlothParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SlothParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SlothParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(SlothParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assign}
	 * labeled alternative in {@link SlothParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(SlothParser.AssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code if}
	 * labeled alternative in {@link SlothParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf(SlothParser.IfContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ifelse}
	 * labeled alternative in {@link SlothParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfelse(SlothParser.IfelseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code while}
	 * labeled alternative in {@link SlothParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile(SlothParser.WhileContext ctx);
	/**
	 * Visit a parse tree produced by the {@code print}
	 * labeled alternative in {@link SlothParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint(SlothParser.PrintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code println}
	 * labeled alternative in {@link SlothParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintln(SlothParser.PrintlnContext ctx);
	/**
	 * Visit a parse tree produced by the {@code begin}
	 * labeled alternative in {@link SlothParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBegin(SlothParser.BeginContext ctx);
	/**
	 * Visit a parse tree produced by the {@code timesdiv}
	 * labeled alternative in {@link SlothParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTimesdiv(SlothParser.TimesdivContext ctx);
	/**
	 * Visit a parse tree produced by the {@code plusminus}
	 * labeled alternative in {@link SlothParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlusminus(SlothParser.PlusminusContext ctx);
	/**
	 * Visit a parse tree produced by the {@code not}
	 * labeled alternative in {@link SlothParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNot(SlothParser.NotContext ctx);
	/**
	 * Visit a parse tree produced by the {@code compare}
	 * labeled alternative in {@link SlothParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompare(SlothParser.CompareContext ctx);
	/**
	 * Visit a parse tree produced by the {@code justterm}
	 * labeled alternative in {@link SlothParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJustterm(SlothParser.JusttermContext ctx);
	/**
	 * Visit a parse tree produced by the {@code or}
	 * labeled alternative in {@link SlothParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOr(SlothParser.OrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code and}
	 * labeled alternative in {@link SlothParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnd(SlothParser.AndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code true}
	 * labeled alternative in {@link SlothParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrue(SlothParser.TrueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code false}
	 * labeled alternative in {@link SlothParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFalse(SlothParser.FalseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code realval}
	 * labeled alternative in {@link SlothParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRealval(SlothParser.RealvalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intval}
	 * labeled alternative in {@link SlothParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntval(SlothParser.IntvalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code strval}
	 * labeled alternative in {@link SlothParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStrval(SlothParser.StrvalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parens}
	 * labeled alternative in {@link SlothParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParens(SlothParser.ParensContext ctx);
	/**
	 * Visit a parse tree produced by the {@code id}
	 * labeled alternative in {@link SlothParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitId(SlothParser.IdContext ctx);
	/**
	 * Visit a parse tree produced by the {@code readint}
	 * labeled alternative in {@link SlothParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReadint(SlothParser.ReadintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code readreal}
	 * labeled alternative in {@link SlothParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReadreal(SlothParser.ReadrealContext ctx);
	/**
	 * Visit a parse tree produced by the {@code readbool}
	 * labeled alternative in {@link SlothParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReadbool(SlothParser.ReadboolContext ctx);
	/**
	 * Visit a parse tree produced by the {@code readstr}
	 * labeled alternative in {@link SlothParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReadstr(SlothParser.ReadstrContext ctx);
}