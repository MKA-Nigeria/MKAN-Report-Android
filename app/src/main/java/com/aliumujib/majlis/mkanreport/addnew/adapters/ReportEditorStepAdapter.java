package com.aliumujib.majlis.mkanreport.addnew.adapters;

import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;

import com.aliumujib.majlis.mkanreport.addnew.activity.AbstractStepperActivity;
import com.aliumujib.majlis.mkanreport.addnew.activity.BaseReportEditorActivity;

import com.aliumujib.majlis.mkanreport.addnew.fragments.AtfalPart1Fragment;
import com.aliumujib.majlis.mkanreport.addnew.fragments.AtfalPart2Fragment;
import com.aliumujib.majlis.mkanreport.addnew.fragments.IshaatPart1Fragment;
import com.aliumujib.majlis.mkanreport.addnew.fragments.IshaatPart2Fragment;
import com.aliumujib.majlis.mkanreport.addnew.fragments.KhidmatEKhalqPart1Fragment;
import com.aliumujib.majlis.mkanreport.addnew.fragments.KhidmatEKhalqPart2Fragment;
import com.aliumujib.majlis.mkanreport.addnew.fragments.MaalFragment;
import com.aliumujib.majlis.mkanreport.addnew.fragments.MuhasbaFragment;
import com.aliumujib.majlis.mkanreport.addnew.fragments.SanatoTijaratPart1Fragment;
import com.aliumujib.majlis.mkanreport.addnew.fragments.SanatoTijaratPart2Fragment;
import com.aliumujib.majlis.mkanreport.addnew.fragments.SihateJismaniPart1;
import com.aliumujib.majlis.mkanreport.addnew.fragments.SihateJismaniPart2;
import com.aliumujib.majlis.mkanreport.addnew.fragments.TablighPart1Fragment;
import com.aliumujib.majlis.mkanreport.addnew.fragments.TablighPart2Fragment;
import com.aliumujib.majlis.mkanreport.addnew.fragments.TahrikEJadeedFragment;
import com.aliumujib.majlis.mkanreport.addnew.fragments.TajneedFragment;
import com.aliumujib.majlis.mkanreport.addnew.fragments.TaleemFragment;
import com.aliumujib.majlis.mkanreport.addnew.fragments.TarbiyyaFragment;
import com.aliumujib.majlis.mkanreport.addnew.fragments.TarbiyyatNouMubayeen;
import com.aliumujib.majlis.mkanreport.addnew.fragments.UmmomiPart1Fragment;
import com.aliumujib.majlis.mkanreport.addnew.fragments.UmmoomiPart2Fragment;
import com.aliumujib.majlis.mkanreport.addnew.fragments.UmoorETulabaFragment;
import com.aliumujib.majlis.mkanreport.addnew.fragments.WaqarAmalFragment;
import com.stepstone.stepper.Step;
import com.stepstone.stepper.viewmodel.StepViewModel;

public class ReportEditorStepAdapter extends EditReportStepAdapter {
    BaseReportEditorActivity context;

    public ReportEditorStepAdapter(@NonNull FragmentManager fm, @NonNull AbstractStepperActivity context) {
        super(fm, context);
        this.context = (BaseReportEditorActivity) context;
    }


    @Override
    public Step createStep(int position) {
        switch (position) {
            case 0:
                return IshaatPart2Fragment.newInstance();
            //return EteemadFragment.newInstance();
            case 1:
                return TajneedFragment.newInstance();
            case 2:
                return TaleemFragment.newInstance();
            case 3:
                return TarbiyyaFragment.newInstance();
            case 4:
                return TablighPart1Fragment.newInstance();
            case 5:
                return TablighPart2Fragment.newInstance();
            case 6:
                return TarbiyyatNouMubayeen.newInstance();
            case 7:
                return UmoorETulabaFragment.newInstance();
            case 8:
                return WaqarAmalFragment.newInstance();
            case 9:
                return AtfalPart1Fragment.newInstance();
            case 10:
                return AtfalPart2Fragment.newInstance();
            case 11:
                return MaalFragment.newInstance();
            case 12:
                return TahrikEJadeedFragment.newInstance();
            case 13:
                return MuhasbaFragment.newInstance();
            case 14:
                return SihateJismaniPart1.newInstance();
            case 15:
                return SihateJismaniPart2.newInstance();
            case 16:
                return SanatoTijaratPart1Fragment.newInstance();
            case 17:
                return SanatoTijaratPart2Fragment.newInstance();
            case 18:
                return IshaatPart1Fragment.newInstance();
            case 19:
                return IshaatPart2Fragment.newInstance();
            case 20:
                return KhidmatEKhalqPart1Fragment.newInstance();
            case 21:
                return KhidmatEKhalqPart2Fragment.newInstance();
            case 22:
                return UmmomiPart1Fragment.newInstance();
            case 23:
                return UmmoomiPart2Fragment.newInstance();
            default:
                throw new IllegalArgumentException("Unsupported position: " + position);
        }
    }

    @NonNull
    @Override
    public StepViewModel getViewModel(@IntRange(from = 0) int position) {
        String[] titles = {"Eteemad", "Tajneed", "Taaleem", "Tarbiyya", "Tabligh Section 1", "Tabligh Section 2",
                "Tarbiyat Nou Mubayeen", "Umoor e Tulaba", "Waqar e Amal", "Atfal Section 1", "Atfal Section 2",
                "Maal", "Tahrik Jadeed", "Muhasba", "Sihat - e - Jismana Section 1", "Sihat - e - Jismana Section 2", "Sinat - o - Tijarat Section 1", "Sinat - o - Tijarat Section 2", "Ishaat Section 1", "Ishaat Section 2",
                "Khidmat - e - Khalq Section 1", "Khidmat - e - Khalq Section 2", "Umoomi Section 1", "Umoomi Section 2"};
        context.setActionBarTitle(titles[position]);
        return new StepViewModel.Builder(context)
                .setTitle(titles[position])
                .create();
    }

    @Override
    public int getCount() {
        return 22;
    }
}