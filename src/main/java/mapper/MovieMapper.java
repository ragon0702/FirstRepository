package mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import config.DBManager;
import dto.MovieDTO;

public class MovieMapper {
	private static MovieMapper instance = new MovieMapper();

	private SqlSession session;
	
	private MovieMapper() {
		session = DBManager.getInstance().getSession();
	}

	public static MovieMapper getInstance() {
		if(instance == null)
			instance = new MovieMapper();
		return instance;
	}

	public int insertMovie(MovieDTO dto) {
		return session.insert("insertMovie", dto);
	}

	public List<MovieDTO> selectAllMovie() {
		return session.selectList("selectAllMovie");
	}

	
}







