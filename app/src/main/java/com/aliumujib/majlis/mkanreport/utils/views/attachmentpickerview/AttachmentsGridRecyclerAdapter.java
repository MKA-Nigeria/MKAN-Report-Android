package com.aliumujib.majlis.mkanreport.utils.views.attachmentpickerview;

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.alium.mkan_report_data.models.Attachment;
import com.aliumujib.majlis.mkanreport.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by abdulmujibaliu on 8/12/17.
 */

public class AttachmentsGridRecyclerAdapter extends RecyclerView.Adapter<AttachmentsGridRecyclerAdapter.AttachmentViewHolder> {

    protected List<Attachment> attachmentList;
    protected RecyclerClickListener recyclerClickListener;
    protected Context mContext;
    protected String TAG = getClass().getSimpleName();

    public AttachmentsGridRecyclerAdapter(List<Attachment> attachmentList, Context context) {
        this.attachmentList = attachmentList;
        this.mContext = context;
    }

    @Override
    public AttachmentViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.grid_file_item, parent, false);
        return new AttachmentViewHolder(v);
    }


    @Override
    public void onBindViewHolder(final AttachmentViewHolder holder, final int position) {
        final Attachment attachment = attachmentList.get(position);
        holder.bindAttachment(attachment);

    }

    @Override
    public int getItemCount() {
        return attachmentList.size();
    }

    public class AttachmentViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.file_icon)
        ImageView fileIcon;
        @BindView(R.id.file_name)
        TextView fileName;

        AttachmentViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }


        public void bindAttachment(Attachment attachment) {
            fileName.setText(attachment.getmFileName());
            fileIcon.setImageResource(getResIDFromFileType(attachment.getmAttachmentType()));
        }

    }

    private @DrawableRes int getResIDFromFileType(Attachment.AttachmentType attachmentType){
        if(attachmentType == Attachment.AttachmentType.WORD){
            return R.drawable.ic_file_word_box_grey600_48dp;
        }else if(attachmentType == Attachment.AttachmentType.EXCEL){
            return R.drawable.ic_file_excel_grey600_48dp;
        }else if(attachmentType == Attachment.AttachmentType.PDF){
            return R.drawable.ic_file_pdf_grey600_48dp;
        }else {
            return R.drawable.ic_file_grey600_48dp;
        }
    }

    public void setRecyclerClickListener(RecyclerClickListener recyclerClickListener) {
        this.recyclerClickListener = recyclerClickListener;
    }

    public interface RecyclerClickListener {
        void onClick(int position);
    }

}
