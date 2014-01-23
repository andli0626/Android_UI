package com.lilin.listview.util;

import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.lilin.listview.modal.TestModel;

public class JieXiXMLHelper {

	public static ArrayList<TestModel> CollectTaskListXML(String xml) {
		try {
			Document document = null;
			try {
				document = DocumentHelper.parseText(xml);
			} catch (DocumentException e) {
				e.printStackTrace();
			}
			ArrayList deal_List = new ArrayList();
			Element root = document.getRootElement();// 得到根元素
			List focs = root.elements();
			for (int i = 0; i < focs.size(); i++) {
				TestModel deal = new TestModel();
				Element foc = (Element) focs.get(i);
				// private String ishuizong;是否汇总
				// private String categoryguid;主题类别Guid
				// private Date operatedate;操作日期
				// private String categoryname;主题类别名称
				// private String taskguid;所属任务Guid
				// private String belongxiaqucode;所属辖区号
				// private String addressguid;采集地点Guid
				// private String units;计量单位
				// private String yearflag;年份标识
				// private String addressname;采集地点名称
				// private String rowguid;默认主键字段
				// private String taskname;所属任务名称
				// private String operateusername;操作者名字
				// private int rowid;序号
				// private String status;状态
				// private Date senddate;任务下发日期
				// private Date collectdate;计划采集时间
				// private String subcategoryguid;小类别guid
				// private String subcategoryname; 小类别名称
				// private String collecttype;采集类型
				// private String categorycode;主题code
				// private String isgd;是否固定任务
				if (foc.element("ishuizong") != null)
					deal.ishuizong = foc.elementText("ishuizong");
				if (foc.element("categoryguid") != null)
					deal.categoryguid = foc.elementText("categoryguid");
				if (foc.element("operatedate") != null)
					deal.operatedate = foc.elementText("operatedate");
				if (foc.element("rowguid") != null)
					deal.rowguid = foc.elementText("rowguid");
				if (foc.element("categoryname") != null)
					deal.categoryname = foc.elementText("categoryname");
				if (foc.element("taskguid") != null)
					deal.taskguid = foc.elementText("taskguid");
				if (foc.element("addressguid") != null)
					deal.addressguid = foc.elementText("addressguid");
				if (foc.element("addressname") != null)
					deal.addressname = foc.elementText("addressname");
				if (foc.element("rowguid") != null)
					deal.rowguid = foc.elementText("rowguid");
				if (foc.element("taskname") != null)
					deal.taskname = foc.elementText("taskname");
				if (foc.element("rowid") != null)
					deal.rowid = foc.elementText("rowid");
				if (foc.element("status") != null)
					deal.status = foc.elementText("status");
				if (foc.element("collectdate") != null)
					deal.collectdate = foc.elementText("collectdate");
				if (foc.element("senddate") != null)
					deal.senddate = foc.elementText("senddate");
				if (foc.element("subcategoryguid") != null)
					deal.subcategoryguid = foc.elementText("subcategoryguid");

				if (foc.element("subcategoryname") != null)
					deal.subcategoryname = foc.elementText("subcategoryname");
				if (foc.element("collecttype") != null)
					deal.collecttype = foc.elementText("collecttype");
				if (foc.element("categorycode") != null)
					deal.categorycode = foc.elementText("categorycode");
				if (foc.element("isgd") != null)
					deal.isgd = foc.elementText("isgd");
				deal_List.add(deal);
			}
			return deal_List;
		} catch (Exception e) {
//			Toast.makeText(context, e.toString(), Toast.LENGTH_LONG).show();
			e.printStackTrace();
		}
		return null;

	}
}
