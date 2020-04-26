import java.util.Scanner;

public class Puzzle {
    //Gretchen Marie edited by Mart
    private String puzzleID;
    private String puzzleName;
    private String puzzleQuestion;
    private String puzzleAnswer;
    private int attempt;
    private String hint;
    private float reward;
    private String secondAns;

    public Puzzle(String puzzleID, String puzzleName, String puzzleQuestion, String puzzleAnswer,
                  int attempt, String hint, float reward,String SecondAns) {
        this.puzzleID = puzzleID;
        this.puzzleName = puzzleName;
        this.puzzleQuestion = puzzleQuestion;
        this.puzzleAnswer = puzzleAnswer;
        this.attempt = attempt;
        this.hint = hint;
        this.reward = reward;
        if(SecondAns.equalsIgnoreCase("Null")){
            this.secondAns = "";
        }else{
            this.secondAns = SecondAns;
        }
    }

    public String getPuzzleID() {
        return puzzleID;
    }

    public void setPuzzleID(String puzzleID) {
        this.puzzleID = puzzleID;
    }

    public String getPuzzleName() {
        return puzzleName;
    }

    public void setPuzzleName(String puzzleName) {
        this.puzzleName = puzzleName;
    }

    public String getPuzzleQuestion() {
        return puzzleQuestion;
    }

    public void setPuzzleQuestion(String puzzleQuestion) {
        this.puzzleQuestion = puzzleQuestion;
    }

    public String getPuzzleAnswer() {
        return puzzleAnswer;
    }

    public void setPuzzleAnswer(String puzzleAnswer) {
        this.puzzleAnswer = puzzleAnswer;
    }

    public int getAttempt() {
        return attempt;
    }

    public void setAttempt(int attempt) {
        this.attempt = attempt;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public float getReward() {
        return reward;
    }

    public void setReward(Float reward) {
        this.reward = reward;
    }

    public float solvePuzzle(){
        int curA=0;
        Scanner in = new Scanner(System.in);
        System.out.println(puzzleQuestion);
        boolean active = true;
        String response;
        do{
            System.out.print("Please type a solution: ");
            response = in.nextLine();
            if(response.equalsIgnoreCase(puzzleAnswer)||response.equalsIgnoreCase(secondAns)){
                System.out.println("you solved the puzzle correctly!");
                active = false;
            }else{
                curA++;
                System.out.println("the answer you provided is wrong, you still have "+(attempt-curA)+
                        " remaining attempts. Try one more time ");
                if (attempt - curA == 0){
                    active = false;
                    reward = 0f;
                    System.out.println("you failed the puzzle!");
                }
            }
        }while(active);
        return reward;
    }
}
