package projectthree;

import org.sat4j.minisat.SolverFactory;
import org.sat4j.reader.DimacsReader;
import org.sat4j.reader.ParseFormatException;
import org.sat4j.reader.Reader;
import org.sat4j.specs.ContradictionException;
import org.sat4j.specs.IProblem;
import org.sat4j.specs.ISolver;
import org.sat4j.specs.TimeoutException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class SudokuSolver {


    public static void main (String args[]) throws FileNotFoundException {

        ISolver solver = SolverFactory.newDefault();
        solver.setTimeout(3600); // 1 hour timeout

        Reader reader = new DimacsReader(solver);

        Sudoku sudOne = new Sudoku("puz1");





            try {

                PrintWriter out = new PrintWriter("sudokuCNF.cnf");

                IProblem problem = reader.parseInstance("sudokuCNF.cnf");
                if (problem.isSatisfiable()) {
                    System.out.println("Satisfiable !");
                    reader.decode(problem.model());
                } else {
                    System.out.println("Unsatisfiable !");
                }
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
            } catch (ParseFormatException e) {
                System.out.println("Parse format exception");
                e.printStackTrace();
            }
            catch (IOException e) {
                // TODO Auto-generated catch block
            } catch (ContradictionException e) {
                System.out.println("Unsatisfiable (trivial)!");
            } catch (TimeoutException e) {
                System.out.println("Timeout, sorry!");
            }


    }

  /**  public static void main(String[] args) {


        ISolver solver = SolverFactory.newDefault();

        Reader reader = new DimacsReader(solver);
        PrintWriter out = new PrintWriter(System.out,true);
        // CNF filename is given on the command line
        try {
            IProblem problem = reader.parseInstance(args[0]);
            if (problem.isSatisfiable()) {
                System.out.println("Satisfiable !");
                reader.decode(problem.model(),out);
            } else {
                System.out.println("Unsatisfiable !");
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
        } catch (ParseFormatException e) {
            // TODO Auto-generated catch block
        } catch (IOException e) {
            // TODO Auto-generated catch block
        } catch (ContradictionException e) {
            System.out.println("Unsatisfiable (trivial)!");
        } catch (TimeoutException e) {
            System.out.println("Timeout, sorry!");
        }
    } **/
}

