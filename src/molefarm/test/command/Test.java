package molefarm.test.command;

import molefarm.pattern.command.Command;
import molefarm.pattern.command.conc.FertilizerCommand;
import molefarm.pattern.command.conc.SeedCommand;

public class Test {
    public static void main(String[] args) {
        Command fertilizerCommand = new FertilizerCommand();
        Command seedCommand = new SeedCommand();
        fertilizerCommand.execute("高级肥料",1);
        seedCommand.execute("小麦种子",-1);
    }
}
