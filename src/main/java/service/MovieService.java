package service;

import java.util.List;

import dto.MovieDTO;
import mapper.MovieMapper;

public class MovieService {
	private static MovieService instance = new MovieService();

	private MovieService() {
	}

	public static MovieService getInstance() {
		if(instance == null)
			instance = new MovieService();
		return instance;
	}

	public int insertMovie(MovieDTO dto) {
		//System.out.println(dto);
		return MovieMapper.getInstance().insertMovie(dto);
	}

	public List<MovieDTO> selectAllMovie() {
		return MovieMapper.getInstance().selectAllMovie();
	}
	
	
}




