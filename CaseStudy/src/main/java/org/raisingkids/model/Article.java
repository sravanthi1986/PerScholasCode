package org.raisingkids.model;

public class Article {
	private int articleId;
	private String articleTitle;
	private String articleAuthor;
	private String articleContent;
	private int categoryId;
	private String articleUrl;
	
	public Article() {}
	public Article(int articleId, String articleTitle, String articleAuthor, String articleContent, int categoryId) {
		super();
		this.articleId = articleId;
		this.articleTitle = articleTitle;
		this.articleAuthor = articleAuthor;
		this.articleContent = articleContent;
		this.categoryId = categoryId;
	}
	public Article(String articleTitle, String articleAuthor, String articleContent, int categoryId,String articleUrl) {
		super();
		this.articleTitle = articleTitle;
		this.articleAuthor = articleAuthor;
		this.articleContent = articleContent;
		this.categoryId = categoryId;
		this.articleUrl=articleUrl;
	}
	/**
	 * @return the articleId
	 */
	public int getArticleId() {
		return articleId;
	}
	/**
	 * @param articleId the articleId to set
	 */
	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}
	/**
	 * @return the articleTitle
	 */
	public String getArticleTitle() {
		return articleTitle;
	}
	/**
	 * @param articleTitle the articleTitle to set
	 */
	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}
	/**
	 * @return the articleAuthor
	 */
	public String getArticleAuthor() {
		return articleAuthor;
	}
	/**
	 * @param articleAuthor the articleAuthor to set
	 */
	public void setArticleAuthor(String articleAuthor) {
		this.articleAuthor = articleAuthor;
	}
	/**
	 * @return the articleContent
	 */
	public String getArticleContent() {
		return articleContent;
	}
	/**
	 * @param articleContent the articleContent to set
	 */
	public void setArticleContent(String articleContent) {
		this.articleContent = articleContent;
	}
	/**
	 * @return the categoryId
	 */
	public int getCategoryId() {
		return categoryId;
	}
	/**
	 * @param categoryId the categoryId to set
	 */
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	/**
	 * @return the articleUrl
	 */
	public String getArticleUrl() {
		return articleUrl;
	}
	/**
	 * @param articleUrl the articleUrl to set
	 */
	public void setArticleUrl(String articleUrl) {
		this.articleUrl = articleUrl;
	}
	
	

}
