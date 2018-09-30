package model;

public class Books {
    String title , author, cover,isbn,barcode,edition,pageNumbers,publisher
            ,translator,language,linguisticEditor,description,profileDesigner,available,category,type;

    public Books() {
    }

    public Books(String title, String author, String cover, String isbn, String barcode, String edition, String pageNumbers, String publisher,
                 String translator, String language, String linguisticEditor, String description, String profileDesigner, String available, String category, String type) {
        this.title = title;
        this.author = author;
        this.cover = cover;
        this.isbn = isbn;
        this.barcode = barcode;
        this.edition = edition;
        this.pageNumbers = pageNumbers;
        this.publisher = publisher;
        this.translator = translator;
        this.language = language;
        this.linguisticEditor = linguisticEditor;
        this.description = description;
        this.profileDesigner = profileDesigner;
        this.available = available;
        this.category = category;
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public String getPageNumbers() {
        return pageNumbers;
    }

    public void setPageNumbers(String pageNumbers) {
        this.pageNumbers = pageNumbers;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getTranslator() {
        return translator;
    }

    public void setTranslator(String translator) {
        this.translator = translator;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getLinguisticEditor() {
        return linguisticEditor;
    }

    public void setLinguisticEditor(String linguisticEditor) {
        this.linguisticEditor = linguisticEditor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProfileDesigner() {
        return profileDesigner;
    }

    public void setProfileDesigner(String profileDesigner) {
        this.profileDesigner = profileDesigner;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
