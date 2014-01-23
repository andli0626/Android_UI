package com.df.dianping;

import java.util.List;

public interface ServerListener 
{
	@SuppressWarnings("rawtypes")
	void serverDataArrived(List list, boolean isEnd);
}
