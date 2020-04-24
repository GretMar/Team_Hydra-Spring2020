public class Puzzle {
    //Gretchen Marie
    private int puzzleID;
    private String puzzleName;
    private String puzzleQuestion;
    private String puzzleAnswer;
    private int attempt;
    private String hint;
    private String reward;

    public Puzzle(int puzzleID, String puzzleName, String puzzleQuestion, String puzzleAnswer,
                  int attempt, String hint, String reward) {
        this.puzzleID = puzzleID;
        this.puzzleName = puzzleName;
        this.puzzleQuestion = puzzleQuestion;
        this.puzzleAnswer = puzzleAnswer;
        this.attempt = attempt;
        this.hint = hint;
        this.reward = reward;
    }

    public int getPuzzleID() {
        return puzzleID;
    }

    public void setPuzzleID(int puzzleID) {
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

    public String getReward() {
        return reward;
    }

    public void setReward(String reward) {
        this.reward = reward;
    }
}
