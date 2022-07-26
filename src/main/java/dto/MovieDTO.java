package dto;

public class MovieDTO {
	private int bno;
	private String title;
	private String openDate;
	private int audienceCount;
	private String director;

	public MovieDTO() {
	}

	public MovieDTO(int bno, String title, String openDate, int audienceCount, String director) {
		super();
		this.bno = bno;
		this.title = title;
		this.openDate = openDate;
		this.audienceCount = audienceCount;
		this.director = director;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getOpenDate() {
		return openDate;
	}

	public void setOpenDate(String openDate) {
		this.openDate = openDate;
	}

	public int getAudienceCount() {
		return audienceCount;
	}

	public void setAudienceCount(int audienceCount) {
		this.audienceCount = audienceCount;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	@Override
	public String toString() {
		return "MovieDTO [bno=" + bno + ", title=" + title + ", openDate=" + openDate + ", audienceCount="
				+ audienceCount + ", director=" + director + "]";
	}
	
}
