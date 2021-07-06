package du.board.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import du.board.dao.BoardDAO;
import du.board.domain.BoardVO;
import egovframework.rte.psl.dataaccess.EgovAbstractMapper;

@Repository
public class BoardDAOImpl extends EgovAbstractMapper implements BoardDAO {

	@Override
	public List<BoardVO> selectBoardList() {
		return selectList("Board.selectBoardList");
	}

}
