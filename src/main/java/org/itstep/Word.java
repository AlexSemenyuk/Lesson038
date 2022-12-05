package org.itstep;

public class Word {
    static int idx = 0;
    private int number;
    private String word;
    private int amount;

    public Word() {
        this("", 0);
    }

    public Word(String word, int amount) {
        this.number = ++ idx;
        this.word = word;
        this.amount = amount;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return word + ": " + amount + "\n";
    }
}
