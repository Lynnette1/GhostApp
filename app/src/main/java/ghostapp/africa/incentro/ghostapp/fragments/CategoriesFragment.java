package ghostapp.africa.incentro.ghostapp.fragments;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import ghostapp.africa.incentro.ghostapp.R;
import ghostapp.africa.incentro.ghostapp.activity.DreamsActivity;
import ghostapp.africa.incentro.ghostapp.adapter.DreamAdapter;
import ghostapp.africa.incentro.ghostapp.model.Dream;
import ghostapp.africa.incentro.ghostapp.other.RecyclerTouchListener;


public class CategoriesFragment extends Fragment {


    public CategoriesFragment() {
        // Required empty public constructor
    }

    private RecyclerView recyclerView;
    private DreamAdapter adapter;
    private List<Dream> dreamList;

        @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

                View rootView =inflater.inflate(R.layout.fragment_categories, container, false);


           /// initCollapsingToolbar();

            recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);

            dreamList = new ArrayList<>();
            adapter = new DreamAdapter(getContext(), dreamList);

            RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 3);
            recyclerView.setLayoutManager(mLayoutManager);
            recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setAdapter(adapter);

            recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getActivity(), recyclerView, new RecyclerTouchListener.ClickListener() {
                @Override
                public void onClick(View view, int position) {

                    Intent intent = new Intent(getActivity(),DreamsActivity.class);
                    startActivity(intent);
                }

                @Override
                public void onLongClick(View view, int position) {

                }
            }));



            prepareAlbums();



        return rootView;
    }


    private void prepareAlbums() {
        int[] covers = new int[]{
                R.mipmap.ic_home_black_24dp,
                R.mipmap.ic_home_black_24dp,
                R.mipmap.ic_home_black_24dp,
               };

        Dream a = new Dream("Flower", covers[0]);
        dreamList.add(a);

        a = new Dream("Flying", covers[1]);
        dreamList.add(a);

        a = new Dream("Blood", covers[2]);
        dreamList.add(a);



        adapter.notifyDataSetChanged();
    }

    /**
     * RecyclerView item decoration - give equal margin around grid item
     */
    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }

}
