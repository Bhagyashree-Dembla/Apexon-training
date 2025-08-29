package com.acme;

public class Test {
    private String testId;
    private String testTitle;
    private int testMarks;

    public Test() {}


    public String getTestId() { return testId; }
    public void setTestId(String testId) { this.testId = testId; }

    public String getTestTitle() { return testTitle; }
    public void setTestTitle(String testTitle) { this.testTitle = testTitle; }

    public int getTestMarks() { return testMarks; }
    public void setTestMarks(int testMarks) { this.testMarks = testMarks; }

    public void display() {
        System.out.println("  Test Id    : " + testId);
        System.out.println("  Test Title : " + testTitle);
        System.out.println("  Test Marks : " + testMarks);
    }
}
