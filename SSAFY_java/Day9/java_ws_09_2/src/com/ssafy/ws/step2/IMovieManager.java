package com.ssafy.ws.step2;

public interface IMovieManager {
	
	void add(Movie movie);
	
	Movie[] getList();
	
	Movie[] searchByTitle(String title) throws TitleNotFoundException;
	
	Movie[] getMovies();
	
	SeriesMovie[] getSeriesMovies();
	
	double getRunningTimeAvg();
	//코드를 작성해주세요. 
}
