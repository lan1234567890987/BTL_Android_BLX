package com.example.btl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

import object.LyThuyet;

public class DBHelper extends SQLiteOpenHelper{

    public DBHelper(@Nullable Context context)
    {
        super(context, "DB_OnThiBLX", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE TaiKhoan(" +
                "TenDN varchar  primary key," +
                "MatKhau varchar"+
                ")"
        );
        sqLiteDatabase.execSQL("CREATE TABLE LyThuyet(" +
                "CauHoi varchar  primary key," +
                "DapAn1 varchar," +
                "DapAn2 varchar," +
                "DapAn3 varchar," +
                "DapAnDung varchar" +
                ")"
        );

        sqLiteDatabase.execSQL("CREATE TABLE LyThuyetBienBao(" +
                "CauHoi text  primary key," +
                "HinhAnh integer," +
                "DapAn1 text," +
                "DapAn2 text," +
                "DapAn3 text," +
                "DapAnDung text" +
                ")"
        );

        sqLiteDatabase.execSQL("CREATE TABLE LyThuyetHinhAnh(" +
                "CauHoi text  primary key," +
                "HinhAnh interger," +
                "DapAn1 text," +
                "DapAn2 text," +
                "DapAn3 text," +
                "DapAnDung text" +
                ")"
        );

        sqLiteDatabase.execSQL("CREATE TABLE BienBao(" +
                "SoHieu text  primary key," +
                "HinhAnh interger," +
                "TenBienBao text," +
                "NoiDung text" +
                ")"
        );

        sqLiteDatabase.execSQL("CREATE TABLE Luat(" +
                "SoLuat text  primary key," +
                "NoiDung text," +
                "MucPhat text" +
                ")"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS LyThuyet");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS LyThuyetBienBao");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS LyThuyetHinhAnh");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS BienBao");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Luat");
        onCreate(sqLiteDatabase);
    }
    public  void insertDbLyThuyet(LyThuyet lt) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("CauHoi", lt.getCauHoi());
        contentValues.put("DapAn1", lt.getDapAn1());
        contentValues.put("DapAn2", lt.getDapAn2());
        contentValues.put("DapAn3", lt.getDapAn3());
        contentValues.put("DapAnDung", lt.getDapAnDung());

        int result = (int) db.insert("LyThuyet", null, contentValues);
        db.close();
    }
    public void createLyThuyet() {
        //Kiểm tra dữ liệu đã được add vào DB hay chưa
        String countQuery = "SELECT  * FROM " + "LyThuyet";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();

        if(count == 0)
        {
            LyThuyet lt1 = new LyThuyet("Phần của đường bộ được sử dụng cho các phương tiện giao thông qua lại là gì?","Phần mặt đường và lề đường.","Phần đường xe chạy.","Phần đường xe cơ giới.","2");
            insertDbLyThuyet(lt1);

            LyThuyet lt2 = new LyThuyet("\"Phương tiện tham gia giao thông đường bộ\" gồm những loại nào?","Phương tiện giao thông cơ giới đường bộ.","Phương tiện giao thông thô sơ đường bộ và xe máy chuyên dùng.","Cả ý 1 và ý 2.","3");
            insertDbLyThuyet(lt2);

            LyThuyet lt3 = new LyThuyet("Khi đang lái xe mô tô và ô tô, nếu có nhu cầu sử dụng điện thoại để nhắn tin hoặc gọi điện, người lái xe phải thực hiện như thế nào trong các tình huống nêu dưới đây?","Giảm tốc độ để đảm bảo an toàn với xe phía trước và sử dụng điện thoại để liên lạc.","Giảm tốc độ để dừng xe ở nơi cho phép dừng xe sau đó sử dụng điện thoại để liên lạc.","Tăng tốc độ để cách xa xe phía sau và sử dụng điện thoại để liên lạc.","2");
            insertDbLyThuyet(lt3);

            LyThuyet lt4 = new LyThuyet("Trong trường hợp đặc biệt, để được lắp đặt, sử dụng còi, đèn không đúng với thiết kế của nhà sản xuất đối với từng loại xe cơ giới bạn phải đảm bảo yêu cầu nào dưới đây?","Phải đảm bảo phụ tùng do đúng nhà sản xuất đó cung cấp.","Phải được chấp thuận của cơ quan có thẩm quyền.","Phải là xe đăng ký và hoạt động tại các khu vực có địa hình phức tạp.","2");
            insertDbLyThuyet(lt4);

            LyThuyet lt5 = new LyThuyet("Trên đường một chiều có vạch kẻ phân làn đường, xe thô sơ và xe cơ giới phải đi như thế nào là đúng quy tắc giao thông?","Xe thô sơ phải đi trên làn đường bên trái ngoài cùng, xe cơ giới, xe máy chuyên dùng đi trên làn đường bên phải.","Xe thô sơ phải đi trên làn đường bên phải trong cùng; xe cơ giới, xe máy chuyên dùng đi trên làn đường bên trái.","Xe thô sơ đi trên làn đường phù hợp không gây cản trở giao thông, xe cơ giới, xe máy chuyên dùng đi trên làn đường bên phải.","2");
            insertDbLyThuyet(lt5);

            LyThuyet lt6 = new LyThuyet("Tại nơi đường bộ giao nhau cùng mức với đường sắt chỉ có đèn tín hiệu hoặc chuông báo hiệu, khi đèn tín hiệu màu đỏ đã bật sáng hoặc có tiếng chuông báo hiệu, người tham gia giao thông phải dừng lại ngay và giữ khoảng cách tối thiểu bao nhiêu mét tính từ ray gần nhất?","5 mét.","3 mét.","4 mét.","1");
            insertDbLyThuyet(lt6);

            LyThuyet lt7 = new LyThuyet("Người lái xe mô tô xử lý như thế nào khi cho xe mô tô phía sau vượt?","Nếu đủ điều kiện an toàn, người lái xe phải giảm tốc độ, đi sát về bên phải của phần đường xe chạy cho đến khi xe sau đã vượt qua, không được gây trở ngại đối với xe xin vượt.","Lái xe vào lề đường bên trái và giảm tốc độ để xe phía sau vượt qua, không được gây trở ngại đối với xe xin vượt.","Nếu đủ điều kiện an toàn, người lái xe phải tăng tốc độ, đi sát về bên phải của phần đường xe chạy cho đến khi xe sau đã vượt qua.","1");
            insertDbLyThuyet(lt7);

            LyThuyet lt8 = new LyThuyet("Khi gặp xe buýt đang dừng đón, trả khách, người điều khiển xe mô tô phải xử lý như thế nào dưới đây để đảm bảo an toàn giao thông?","Tăng tốc độ để nhanh chóng vượt qua bến đỗ.","Giảm tốc độ đến mức an toàn có thể và quan sát người qua đường và từ từ vượt qua xe buýt.","Yêu cầu phải dừng lại phía sau xe buýt chờ xe rời bến mới đi tiếp.","2");
            insertDbLyThuyet(lt8);

            LyThuyet lt9 = new LyThuyet("Người lái xe phải giảm tốc độ thấp hơn tốc độ tối đa cho phép đến mức cần thiết, chú ý quan sát và chuẩn bị sẵn sàng những tình huống có thế xảy ra để phòng ngừa tai nạn trong các trường hợp nào dưới đây?","Gặp biển báo nguy hiểm trên đường.","Gặp biển chỉ dẫn trên đường.","Gặp biển báo hết mọi lệnh cấm.","1");
            insertDbLyThuyet(lt9);

            LyThuyet lt10 = new LyThuyet("Người có giấy phép lái xe mô tô hạng A1 không được phép điều khiển loại xe nào dưới đây?","Xe mô tô có dung tích xi-lanh 125 cm3.","Xe mô tô có dung tích xi-lanh từ 175 cm3 trở lên.","Xe mô tô có dung tích xi-lanh 100 cm3.","2");
            insertDbLyThuyet(lt10);

            LyThuyet lt11 = new LyThuyet("Khái niệm \"phương tiện giao thông thô sơ đường bộ\" được hiểu thế nào là đúng?","Gồm xe đạp (kể cả xe đạp máy, xe đạp điện), xe xích lô, xe lăn dùng cho người khuyết tật, xe súc vật kéo và các loại xe tương tự.","Gồm xe đạp (kể cả xe đạp máy, xe đạp điện), xe gắn máy, xe cơ giới dùng cho người khuyết tật và xe máy chuyên dùng.","Gồm xe ô tô, máy kéo, rơ moóc hoặc sơ mi rơ moóc được kéo bởi xe ô tô, máy kéo.","1");
            insertDbLyThuyet(lt11);

            LyThuyet lt12 = new LyThuyet("Người lái xe sử dụng đèn như thế nào khi lái xe trong khu đô thị và đông dân cư vào ban đêm?","Bất cứ đèn nào miễn là mắt nhìn rõ phía trước.","Chỉ bật đèn chiếu xa (đèn pha) khi không nhìn rõ đường.","Đèn chiếu gần (đèn cốt).","3");
            insertDbLyThuyet(lt12);

            LyThuyet lt13 = new LyThuyet("Tại nơi đường giao nhau không có báo hiệu đi theo vòng xuyến, người điều khiển phương tiện phải nhường đường như thế nào là đúng quy tắc giao thông?","Phải nhường đường cho xe đi đến từ bên phải.","Xe báo hiệu xin đường trước xe đó được đi trước.","Phải nhường đường cho xe đi đến từ bên trái.","1");
            insertDbLyThuyet(lt13);

            LyThuyet lt14 = new LyThuyet("Trên đoạn đường hai chiều không có giải phân cách giữa, người lái xe không được vượt xe khác trong các trường hợp nào dưới đây?","Xe bị vượt bất ngờ tăng tốc độ và cố tình không nhường đường.","Phát hiện có xe đi ngược chiều.","Cả ý 1 và ý 2.","3");
            insertDbLyThuyet(lt14);

            LyThuyet lt15 = new LyThuyet("Khi điều khiển xe chạy với tốc độ dưới 60 km/h, để đảm bảo khoảng cách an toàn giữa hai xe, người lái xe phải điều khiển xe như thế nào?","Chủ động giữ khoảng cách an toàn phù hợp với xe chạy liền trước xe của mình.","Đảm bảo khoảng cách an toàn theo mật độ phương tiện, tình hình giao thông thực tế.","Cả ý 1 và ý 2.","3");
            insertDbLyThuyet(lt15);

            LyThuyet lt16 = new LyThuyet("Người lái xe phải xử lý như thế nào khi quan sát phía trước thấy người đi bộ đang sang đường tại nơi có vạch đường dành cho người đi bộ để đảm bảo an toàn?","Giảm tốc độ, đi từ từ để vượt qua trước người đi bộ.","Giảm tốc độ, có thể dừng lại nếu cần thiết trước vạch dừng xe để nhường đường cho người đi bộ qua đường.","Tăng tốc độ để vượt qua trước người đi bộ.","2");
            insertDbLyThuyet(lt16);

            LyThuyet lt17 = new LyThuyet("Kỹ thuật cơ bản để giữ thăng bằng khi điều khiển xe mô tô đi trên đường gồ ghề như thế nào trong các trường hợp dưới đây?","Đứng thẳng trên giá gác chân lái sau đó hơi gập đầu gối và khuỷu tay, đi chậm để không nẩy quá mạnh.","Ngồi lùi lại phía sau, tăng ga vượt nhanh qua đoạn đường xóc.","Ngồi lệch sang bên trái hoặc bên phải để lấy thăng bằng đoạn đường gồ ghề.","1");
            insertDbLyThuyet(lt17);

            LyThuyet lt18 = new LyThuyet("Khi lái xe trong khu đô thị và đông dân cư trừ các khu vực có biển cấm sử dụng còi, người lái xe được sử dụng còi như thế nào trong các trường hợp dưới đây?","Từ 22 giờ đêm đến 5 giờ sáng.","Từ 5 giờ sáng đến 22 giờ tối.","Từ 23 giờ đêm đến 5 giờ sáng hôm sau.","2");
            insertDbLyThuyet(lt18);

            LyThuyet lt19 = new LyThuyet("Người có giấy phép lái xe mô tô hạng A1 được phép điều khiển loại xe nào dưới đây?","Xe mô tô hai bánh có dung tích xi-lanh từ 50 cm3 đến dưới 175 cm3.","Xe mô tô ba bánh dùng cho người khuyết tật.","Cả ý 1 và ý 2.","3");
            insertDbLyThuyet(lt19);

            LyThuyet lt20 = new LyThuyet("Tại nơi đường giao nhau, người lái xe đang đi trên đường không ưu tiên phải nhường đường như thế nào là đúng quy tắc giao thông?","Nhường đường cho xe đi ở bên phải mình tới.","Nhường đường cho xe đi ở bên trái mình tới.","Nhường đường cho xe đi trên đường ưu tiên hoặc đường chính từ bất kỳ hướng nào tới.","3");
            insertDbLyThuyet(lt20);
        }
    }
    public ArrayList<LyThuyet> getAllLyThuyet()
    {
        ArrayList<LyThuyet> list = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from LyThuyet", null);

        if (cursor != null)
            cursor.moveToFirst();
        while (cursor.isAfterLast() == false)
        {
            list.add(new LyThuyet(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4)));
            cursor.moveToNext();
        }
        cursor.close();
        db.close();
        return list;
    }

}
