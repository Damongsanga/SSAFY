package com.ssafy.ws.step2;


public class SeriesMovie extends Movie {
	private int series;
	private String episode;

	public SeriesMovie() {
		// TODO Auto-generated constructor stub
	}
	
	public SeriesMovie(int id, String title, String director, String genre, int runningTime, int series, String episode) {
		super(id,title,director,genre, runningTime);
		this.series = series;
		this.episode = episode;
	}

	public int getSeries() {
		return series;
	}

	public void setSeries(int series) {
		this.series = series;
	}

	public String getEpisode() {
		return episode;
	}

	public void setEpisode(String episode) {
		this.episode = episode;
	}

	@Override
	public String toString() {
		return "SeriesMovie [series=" + series + ", episode=" + episode + "id : " + getId() + " title : " + getTitle() +" director : "+ getDirector() + " genre : " + getGenre() + " running time : " + getRunningTime() + "]";
	}
	
}
