import java.io.*;
import java.util.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class Main {
    public static void main(String[] args) {

        try {
            SlothLexer lexer = new SlothLexer(CharStreams.fromFileName(args[0]));
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            SlothParser parser = new SlothParser(tokens);

            // do the parsing
            ParseTree tree = parser.program();

            // visit the tree to execute it
            SlothVisitor visitor = new SlothVisitor();
            visitor.visit(tree);

        } catch (IOException e) {
            System.out.print(Arrays.toString(e.getStackTrace()));
        }
    }
}
