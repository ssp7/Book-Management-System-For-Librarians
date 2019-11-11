package edu.unl.cse.csce361.book_management.blackboard;

import java.util.ArrayList;
import java.util.Observable;

public class BookBuilder extends Observable{

    private String callnumber;
    private String title;
    private String author;
    private String status;
    private String summary;
    private int copyNumber;
    ArrayList<String> PatronHoldList;
    ArrayList<String> BlackList;

    public BookBuilder() {

        this.callnumber = null;
        this.title = "title is unknown";
        this.author = "author is unknown";
        this.status = " Status is unknown ";
        this.summary = "Summary is not presented";
        this.copyNumber = 0;
        PatronHoldList = new ArrayList<>();
        BlackList = new ArrayList<>();
    }
    public BookBuilder setSummary(String summary) {
        this.summary = summary;
        return this;
    }
    public BookBuilder setCopyNumber(int copyNumber2) {
        this.copyNumber = copyNumber;
        return this;
    }
    public BookBuilder setStatus(String status) {
        this.status = status;
        return this;
    }
    public BookBuilder setCallnumber(String callnumber) {
        this.callnumber = callnumber;
        return this;
    }
    public BookBuilder setTitle(String title) {
        this.title = title;
        return this;
    }
    public BookBuilder setAuthor(String author) {
        this.author = author;
        return this;
    }

    public Book build() {
        return new ConcreteBook(callnumber, title, author, status, summary, copyNumber);
    }

    private class ConcreteBook implements Book{

        ConcreteBook(String callnumber, String title, String author, String status, String summary, int copyNumber){


        }
        private  <E> void swap(ArrayList<E> list,int index1,int index2) {
            //å®šä¹‰ç¬¬ä¸‰æ–¹å�˜é‡�
            E e=list.get(index1);
            //äº¤æ�¢å€¼
            list.set(index1, list.get(index2));
            list.set(index2, e);
        }
        @Override
        public void PlacePatronFrontInHoldList(String PatronName){
            PatronHoldList.add(PatronName);
        for (int i=0;i<PatronHoldList.size();i++){
            if (PatronHoldList.get(i).equals(PatronName)){
                swap(PatronHoldList,i,0);
            }
        }

        }

        @Override
        public void RemovePatronForeverInHoldList(String PatronName){
            PatronHoldList.remove(PatronName);
        }

        @Override
        public ArrayList<String> BlackList() {
            return BlackList;
        }

        @Override
        public void AddPatron(String PatronName) {
            if (!BlackList.contains(PatronName)) {
                PatronHoldList.add(PatronName);
            }
        }


        @Override
        public String getCallNumber() {
            // TODO Auto-generated method stub

            return callnumber;
        }

        @Override
        public String getAuthor() {
            // TODO Auto-generated method stub
            return author;
        }

        @Override
        public String getTitle() {
            // TODO Auto-generated method stub
            return title;
        }
        @Override
        public String getStatus() {
            return status;
        }
        @Override
        public String getSummary() {
            return summary;
        }

        @Override
        public int compareTo(Object o) {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        public int getCopyNumber() {
            // TODO Auto-generated method stub
            return copyNumber;
        }

        @Override
        public String setAuthor(String newAuthor) {
            // TODO Auto-generated method stub
            author = newAuthor;
            return author;
        }

        @Override
        public String setTitle(String newTitle) {
            // TODO Auto-generated method stub
            title = newTitle;
            return title;
        }

        @Override
        public String setSummary(String newSummary) {
            // TODO Auto-generated method stub
            summary = newSummary;
            return summary;
        }

        @Override
        public String setCallNumber(String newCallNumber) {
            // TODO Auto-generated method stub
            callnumber = newCallNumber;
            return callnumber;
        }

        @Override
        public void RemovePatronInHoldList(String PatronName) {
            PatronHoldList.remove(PatronName);
        }

        @Override
        public ArrayList<String> PatronHoldList() {
            return PatronHoldList;
        }
		@Override
		public int setCopyNumber(int newCopyNumber) {
			// TODO Auto-generated method stub
			copyNumber = newCopyNumber;
			return copyNumber;
		}

    }

}

