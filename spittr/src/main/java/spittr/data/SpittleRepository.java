package spittr.data;

import spittr.Spittle;

import java.util.List;

/**
 * @author qiaofei@css.com.cn
 * @version 1.0
 * @description
 * @createTime 14:57 2019/8/16
 * @modifyTime
 */
public interface SpittleRepository {
	List<Spittle> findRecentSpittles();

	List<Spittle> findSpittles(long max, int count);

	Spittle findOne(long id);

	void save(Spittle spittle);
}
