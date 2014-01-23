package com.demo.sectionlistview;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class MainView extends Activity {

	// 这个类用来提供模拟数据
	public class StandardArrayAdapter extends ArrayAdapter<SectionListItem> {
		final SectionListItem[] items;

		public StandardArrayAdapter(final Context context,
				final int textViewResourceId, final SectionListItem[] items) {
			super(context, textViewResourceId, items);
			this.items = items;
		}
	}

	SectionListItem[] exampleArray = { new SectionListItem("Test 1 - A", "A"),
			new SectionListItem("Test 2 - A", "A"),
			new SectionListItem("Test 3 - A", "A"),
			new SectionListItem("Test 4 - B", "B"),
			new SectionListItem("Test 5 - B", "B"),
			new SectionListItem("Test 6 - C", "C"),
			new SectionListItem("Test 7 - D", "D"),
			new SectionListItem("Test 8 - D", "D"),
			new SectionListItem("Test 9 - A again", "A"),
			new SectionListItem("Test 10 - B again", "B"),
			new SectionListItem("Test 11 - B again", "B"),
			new SectionListItem("Test 12 - C again", "C"),
			new SectionListItem("Test 13 - C again", "C"),
			new SectionListItem("Test 14 - C again", "C"), };

	private StandardArrayAdapter arrayAdapter;

	private SectionListAdp sectionAdapter;

	private PinnedHeaderListView listView;

	@Override
	public void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		arrayAdapter = new StandardArrayAdapter(this, R.id.example_text_view,
				exampleArray);
		sectionAdapter = new SectionListAdp(getLayoutInflater(), arrayAdapter);
		listView = (PinnedHeaderListView) findViewById(R.id.section_list_view);
		System.out.println((listView == null) + " " + (sectionAdapter == null));
		listView.setAdapter(sectionAdapter);
		listView.setOnScrollListener(sectionAdapter);

		listView.setPinnedHeaderView(getLayoutInflater().inflate(
				R.layout.list_section, listView, false));
	}

}