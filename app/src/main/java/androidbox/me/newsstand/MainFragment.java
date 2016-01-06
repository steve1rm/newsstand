package androidbox.me.newsstand;


import android.app.Fragment;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {
    private static final String TAG = MainFragment.class.getSimpleName();

    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @SuppressWarnings("deprecated")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        /* Set color of background image */
        final ImageView ivBackground = (ImageView)view.findViewById(R.id.ivBackground);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inMutable = true;

        Bitmap bitmapCouple = BitmapFactory.decodeResource(getResources(), R.drawable.couplePhoto, options);
        Canvas canvas = new Canvas();
        canvas.drawColor(getResources().getColor(R.color.colorBackgroundShape));
        canvas.drawBitmap(bitmapCouple, new Matrix(), null);

        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            // bitmap.eraseColor(getResources().getColor(R.color.colorBackgroundShape));
        }
        else {
//            bitmap.eraseColor(getResources().getColor(R.color.colorBackgroundShape, null));
        }

        ivBackground.setImageBitmap(bitmapCouple);

        /* Attempt 1 */
        // ivBackground.setColorFilter(R.color.colorBackgroundShape, PorterDuff.Mode.DARKEN);
        // ivBackground.setColorFilter(R.color.colorBackgroundShape);
        ivBackground.setImageBitmap(bitmapCouple);

        /* Attempt 2 */
        // Bitmap bitmapCouple = BitmapFactory.decodeResource(getResources(), R.drawable.couplePhoto, options);
        // bitmap.eraseColor(getResources().getColor(R.color.colorBackgroundShape));
        ivBackground.setImageBitmap(bitmapCouple);

        /* Attempt 3 */
        /*Bitmap bitmapCouple = BitmapFactory.decodeResource(getResources(), R.drawable.couplePhoto, options);
        Bitmap newBitmap = Bitmap.createBitmap(bitmapCouple.getWidth(), bitmapCouple.getHeight(), bitmapCouple.getConfig());
        Canvas canvas = new Canvas(newBitmap);
        canvas.drawColor(getResources().getColor(R.color.colorBackgroundShape));
        canvas.drawBitmap(bitmapCouple, 0, 0, null);*/
        ivBackground.setImageBitmap(bitmapCouple);

        /* Attempt 4 */
/*
        Bitmap bitmapCouple = BitmapFactory.decodeResource(getResources(), R.drawable.couplePhoto, options);
        Canvas canvas = new Canvas();
        canvas.drawColor(getResources().getColor(R.color.colorBackgroundShape));
        canvas.drawBitmap(bitmapCouple, new Matrix(), null);
          ivBackground.setImageBitmap(bitmapCouple);
*/


        final Toolbar toolbar = (Toolbar)view.findViewById(R.id.tool_bar);
        AppCompatActivity activity = (AppCompatActivity)getActivity();
        activity.setSupportActionBar(toolbar);

        /* Do not show the title of the app in the toolbar */
        activity.getSupportActionBar().setDisplayShowTitleEnabled(false);

        TabLayout tabLayout = (TabLayout)view.findViewById(R.id.tabLayout);
        tabLayout.addTab(tabLayout.newTab().setCustomView(R.layout.tab_highlights));
        tabLayout.addTab(tabLayout.newTab().setCustomView(R.layout.tab_google));
        tabLayout.addTab(tabLayout.newTab().setCustomView(R.layout.tab_film));

        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.main, menu);
    }
}
