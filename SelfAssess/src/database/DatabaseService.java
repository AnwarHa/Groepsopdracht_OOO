package database;

import database.categoryDatabase.CategoryDatabaseContext;
import database.questionDatabase.QuestionDatabaseContext;
import model.Category;
import model.Question;

import java.util.ArrayList;
import java.util.List;

public class DatabaseService {
    private QuestionDatabaseContext questionDatabaseContext;
    private CategoryDatabaseContext categoryDatabaseContext;

    public DatabaseService(QuestionDatabaseContext q, CategoryDatabaseContext c) {
        setCategoryDatabaseContext(c);
        setQuestionDatabaseContext(q);
        this.categoryDatabaseContext.readData();
    }

    private void setQuestionDatabaseContext(QuestionDatabaseContext questionDatabaseContext) {
        this.questionDatabaseContext = questionDatabaseContext;
    }

    private void setCategoryDatabaseContext(CategoryDatabaseContext categoryDatabaseContext) {
        this.categoryDatabaseContext = categoryDatabaseContext;
    }

    public CategoryDatabaseContext getCategoryDatabaseContext() {
        return categoryDatabaseContext;
    }

    public QuestionDatabaseContext getQuestionDatabaseContext() {
        return questionDatabaseContext;
    }

    public List<Category> readCategories() {
        return categoryDatabaseContext.readData();
    }

    public List<Question> readQuestions() {
        return questionDatabaseContext.readData();
    }

    public void writeCategories(List<Category> categories) {
        if (categories.isEmpty()) {
            throw new DatabaseException("can not set categories: list is empty");
        } else {
            categoryDatabaseContext.writeData(categories);
        }

    }

    public void writeQuestions(List<Question> questions) {
        if (questions.isEmpty()) {
            throw new DatabaseException("can not set questions: list is empty");
        } else {
           questionDatabaseContext.writeData(questions);
        }

    }

    public List<String> getCategoryDescriptions() {
        List<String> desc = new ArrayList<>();
        for (Category c : readCategories()) {
            desc.add(c.getDescription());
        }
        return desc;
    }

    public List<String> getCategoryNames() {
        List<String> names = new ArrayList<>();
        for (Category c : readCategories()) {
            names.add(c.getName());
        }
        return names;
    }

    public List<String> getQuestionStatements(Question q) {
        List<String> stat = new ArrayList<>();
        for (Question c : readQuestions()) {
            if (c.equals(q)) {
                stat = c.getStatements();
                break;
            }
        }
        return stat;
    }

    public ArrayList<String> getCategoryNamesWithoutDuplicates() {
        ArrayList<String> newList = new ArrayList<>();
        for (String s : getCategoryNames()) {
            if (!newList.contains(s)) {
                newList.add(s);
            }
        }
        return newList;
    }

    public Category getCategoryByDescription(String desc) {
        for(Category category: readCategories()){
            if(category.getDescription().equalsIgnoreCase(desc)){
                return category;
            }
        }
        return null;
    }
}



