/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CYKalgorithm;

import CNFParser.Parser;
import Utils.Constans;
import java.io.IOException;

/**
 *
 * @author Dimitris Dedousis <dimitris.dedousis@gmail.com>
 */
public class Main {

    public static void main(String[] args) throws IOException {
        Parser p = new Parser();
        p.parse(Constans.GRAMMAR_PATH);
//        p.printListOfRules();
        CΥΚalgorithm ckYalgorithm = new CΥΚalgorithm(p);
        ckYalgorithm.runAlgorithm("θέλω μια πρωινή πτήση");
        ckYalgorithm.printMatrix();
        TreeParse tree = new TreeParse(ckYalgorithm.getNumOfColumns(), ckYalgorithm.getNumOfRows(), ckYalgorithm.getMatrix());
        
    }
}
