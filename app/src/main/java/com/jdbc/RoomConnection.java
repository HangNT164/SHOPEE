package com.jdbc;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.dao.AccountDao;
import com.dao.AccountDetailDao;
import com.dao.BrandDao;
import com.dao.CategoryDao;
import com.dao.CustomInfoDao;
import com.dao.EvaluateDao;
import com.dao.ImageAvatarDao;
import com.dao.ImageDao;
import com.dao.OrderDao;
import com.dao.OrderDetailDao;
import com.dao.PaymentDao;
import com.dao.PaymentDetailDao;
import com.dao.ProductDao;
import com.dao.RoleDao;
import com.dao.SizeDao;
import com.dao.StatusDao;
import com.dao.StatusOrderDao;
import com.dao.SubCategoryDao;
import com.model.Account;
import com.model.AccountDetail;
import com.model.Category;
import com.model.CustomInfo;
import com.model.Evaluate;
import com.model.Image;
import com.model.ImageAvatar;
import com.model.Order;
import com.model.OrderDetail;
import com.model.Payment;
import com.model.PaymentDetail;
import com.model.Product;
import com.model.Role;
import com.model.Size;
import com.model.Status;
import com.model.StatusOrder;
import com.model.SubCategory;

import static com.jdbc.RoomConnection.DATABASE_VERSION;

@Database(entities = {Account.class, AccountDetail.class, Category.class, CustomInfo.class, Evaluate.class, Image.class, ImageAvatar.class, Order.class, OrderDetail.class, Payment.class, PaymentDetail.class, Product.class, Role.class, Size.class, Status.class, StatusOrder.class, SubCategory.class},
        version = DATABASE_VERSION)

public abstract class RoomConnection extends RoomDatabase {
    private static RoomConnection roomConnection;

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "SHOPEE_DATABASE.db";

    public abstract AccountDao accountDao();

    public abstract AccountDetailDao accountDetailDao();

    public abstract CategoryDao categoryDao();

    public abstract CustomInfoDao customInfoDao();

    public abstract EvaluateDao evaluateDao();

    public abstract ImageAvatarDao imageAvatarDao();

    public abstract ImageDao imageDao();

    public abstract OrderDao orderDao();

    public abstract OrderDetailDao orderDetailDao();

    public abstract PaymentDao paymentDao();

    public abstract PaymentDetailDao paymentDetailDao();

    public abstract ProductDao productDao();

    public abstract RoleDao roleDao();

    public abstract SizeDao sizeDao();

    public abstract StatusDao statusDao();

    public abstract StatusOrderDao statusOrderDao();

    public abstract SubCategoryDao subCategoryDao();

    public abstract BrandDao brandDao();

    public static RoomDatabase getInstance(Context context) {
        if (roomConnection == null) {
            roomConnection = Room.databaseBuilder(context, RoomConnection.class, DATABASE_NAME)
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return roomConnection;
    }
}
