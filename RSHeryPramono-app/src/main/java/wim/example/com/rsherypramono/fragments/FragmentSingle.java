package wim.example.com.rsherypramono.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import wim.example.com.rsherypramono.R;
import wim.example.com.rsherypramono.adapter.SingleListAdapter;
import wim.example.com.rsherypramono.model.Single;
import wim.example.com.rsherypramono.widgets.GridMarginDecoration;

/**
 * Created by Hery Pramono on 07/05/2020.
 */
public class FragmentSingle extends Fragment implements SingleListAdapter.OnGridItemSelectedListener{

    private RecyclerView lvSingle;
    private GridLayoutManager gridLayoutManager;
    private SingleListAdapter singleListAdapter;

    private Context context;

    public static FragmentSingle newInstance() {
        return new FragmentSingle();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_single, container, false);

        lvSingle = (RecyclerView) rootView.findViewById(R.id.lvSingle);

        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        singleListAdapter = new SingleListAdapter(this);
        gridLayoutManager = new GridLayoutManager(context, 2);

        lvSingle.setLayoutManager(gridLayoutManager);
        lvSingle.addItemDecoration(new GridMarginDecoration(context, 2, 2, 2, 2));
        lvSingle.setAdapter(singleListAdapter);

        loadData();
    }

    private void loadData(){
        List<Single> singleList = new ArrayList<>();
        Single single;

        int img[] = {R.drawable.herypramono, R.drawable.dokterkandungan,
                    R.drawable.spesialis, R.drawable.dokter2,
                    R.drawable.cewe, R.drawable.dokter3,
                    R.drawable.dokter1, R.drawable.spesialis};

        String title[] = {"DR Hery Pramono - SPOD (09:00 - 18:00)", "Siti Mahmuda - Spesialis Kandungan (20:00 - 03:00)",
                        "DR Akbar Arian - THT (07:00 - 16:00)", "Ahmad Kamil - Spesialis Gigi (13:00 - 20:00)",
                        "Grealdy Nanda - Apoteker (08:00 - 18:00)", "DR Mayes Diego - Spesialis Otak (10:00 - 13:00)",
                        "Ahmad Silah - Spesialis Ginjal (13:00 - 18:00)", "Afariz - Spesialis Mata (09:00 - 12:00)"};

        for (int i = 0; i < img.length; i++){
            single = new Single();

            single.setImg(img[i]);
            single.setTitle(title[i]);

            singleList.add(single);
        }

        singleListAdapter.addAll(singleList);
    }

    @Override
    public void onGridItemClick(View v, int position) {
        Toast.makeText(context, singleListAdapter.getItem(position).getTitle(), Toast.LENGTH_SHORT).show();
    }
}
