package me.yangjun.study.di;

/**
 * Created by yangjun on 2018/12/13.
 */
public class MalePersonFactory2 {
	public MalePerson newInstance(String work, int workYear, String workPlace) {
		return new MalePerson(work, workYear, workPlace);
	}
}