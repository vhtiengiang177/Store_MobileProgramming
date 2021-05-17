package hcmute.edu.vn.mssv18110276;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CategoryProductAdapter extends RecyclerView.Adapter<CategoryProductAdapter.ViewHolder>{

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private View itemview;
        public TextView name;
        public ImageView img;
        private ItemClickListener itemClickListener;

        public ViewHolder(View itemView) {
            super(itemView);
            itemview = itemView;
            name = itemView.findViewById(R.id.tv_namecategoryproduct);
            img = itemView.findViewById(R.id.iv_category);
            itemView.setOnClickListener(this);
        }

        //Tạo setter cho biến itemClickListenenr
        public void setItemClickListener(ItemClickListener itemClickListener)
        {
            this.itemClickListener = itemClickListener;
        }

        @Override
        public void onClick(View v) {
            itemClickListener.onClick(v,getAdapterPosition(),true);
        }
    }

    private List mCategoryProducts;

    // Lưu context để dễ dàng truy cập
    private Context mContext;

    public CategoryProductAdapter(List _categoryproduct, Context mContext){
        this.mCategoryProducts = _categoryproduct;
        this.mContext = mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Nạp layout view cho phần tử product
        View productView = inflater.inflate(R.layout.item_category, parent, false);
        ViewHolder viewHolder = new ViewHolder(productView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        CategoryProduct categoryproduct = (CategoryProduct) mCategoryProducts.get(position);

        holder.name.setText(categoryproduct.getsName());
        ImageView imageView = holder.img;
        if(categoryproduct.getsSource() == null){
            Uri imgUri= Uri.parse("android.resource://hcmute.edu.vn.mssv18110276/drawable/no_image");
            imageView.setImageURI(null);
            imageView.setImageURI(imgUri);
        }
        else{
            Bitmap bitmap = BitmapFactory.decodeByteArray(categoryproduct.getsSource(), 0, categoryproduct.getsSource().length);
            imageView.setImageBitmap(bitmap);
        }

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isClick) {
                if(isClick){
                    Toast.makeText(mContext, "Click: " + mCategoryProducts.get(position), Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mCategoryProducts.size();
    }
}