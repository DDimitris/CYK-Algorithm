/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CNFParser;

import Utils.Rule;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Dimitris Dedousis <dimitris.dedousis@gmail.com>
 */
public class Parser {

    private List<Rule<String, String, String>> listOfRules = new ArrayList<>();
    private Map<String, String> lexicon = new HashMap<>();

    public Parser() {
    }

    public void parse(String fileUrl) throws IOException {
        File grammar = new File(fileUrl);
        String grammarString = new String(Files.readAllBytes(grammar.toPath()), "UTF-8");
        String substring = grammarString.substring(1);
        String[] initialGrammarSplit = substring.split("\n");
        for (String ruleInGrammar : initialGrammarSplit) {
            String[] ruleSplit = ruleInGrammar.split(" ");
            if (ruleSplit.length == 4) {
                Rule<String, String, String> rule = new Rule<>(ruleSplit[0].trim());
                rule.setFirstSymbol(ruleSplit[2].trim());
                rule.setSecondSymbol(ruleSplit[3].trim());
                listOfRules.add(rule);
            } else {
                lexicon.put(ruleSplit[2].trim(), ruleSplit[0].trim());
            }
        }
    }

    public List<Rule<String, String, String>> getListOfRules() {
        return listOfRules;
    }

    public Map<String, String> getLexicon() {
        return lexicon;
    }

    public void printListOfRules() {
        int count = 1;
        for (Rule rule : listOfRules) {
            System.out.print("Rule " + count + ":\t");
            System.out.print(rule.getNonTerminalSymbol() + " -> ");
            System.out.print(rule.getFirstSymbol() + " ");
            System.out.print(rule.getSecondSymbol());
            System.out.println("");
            count++;
        }
    }
}
