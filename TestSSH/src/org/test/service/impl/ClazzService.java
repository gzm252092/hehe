package org.test.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.test.dao.IClazzDao;
import org.test.po.Clazz;
import org.test.service.IClazzService;
import org.test.vo.ClazzVo;

public class ClazzService implements IClazzService {
	private IClazzDao clazzdao;
	
	@Override
	public List<ClazzVo> findall() throws Exception {
		// TODO Auto-generated method stub
		List<Clazz> lcs = clazzdao.findall();
		List<ClazzVo> lcvs = p2v(lcs);
		return lcvs;
	}

	private List<ClazzVo> p2v(List<Clazz> lcs) {
		// TODO Auto-generated method stub
		if(lcs==null || lcs.size()==0)
			return null;
		List<ClazzVo> lcvs = new ArrayList<ClazzVo>();
		for(Clazz c:lcs){
			ClazzVo cv = p2v(c);
			lcvs.add(cv);
		}
		return lcvs;
	}

	private ClazzVo p2v(Clazz c) {
		// TODO Auto-generated method stub
		ClazzVo cv = new ClazzVo(c.getClaid(),c.getName());
		return cv;
	}

	public void setClazzdao(IClazzDao clazzdao) {
		this.clazzdao = clazzdao;
	}
	
	

}
