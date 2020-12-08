package com.minhduc.android.trieuphumobile.object;

import java.util.ArrayList;
import java.util.Random;

public class NewData {
    public NewData() {
        createQues1();
    }
    public Questions MakeQuestions(int Level){
        Random r = new Random();
        ArrayList<Questions> arr = arrQuestions.get(Level);
        return arr.get(r.nextInt(arr.size()));
    }

    ArrayList<ArrayList<Questions>> arrQuestions = new ArrayList<>();
    public void createQues1() {
        //cau 1
        ArrayList<Questions> arrQuestion1 = new ArrayList<>();
        arrQuestion1.add(createQues("Diễn viên nào đóng vai bà Vi trong phim “Của để dành”?","Hoàng Yến","Lê Mai&Thu An&Thanh Hoa"));
        arrQuestion1.add(createQues("Pôn Pốt mở đầu xâm lược biên giới tây nam nước ta vào ngày tháng năm nào?","21/12/1978","20/12/1978&22/12/1978&24/12/1978"));
        arrQuestions.add(arrQuestion1);

        //cau 2
        ArrayList<Questions> arrQuestion2 = new ArrayList<>();
        arrQuestion2.add(createQues("Bức tượng cao nhất Trung Quốc?","Trung Nguyên Đại Phật","Linh Sơn Đại Phật&Tích Thủy Đại Phật&Lạc Sơn Đại Phật"));
        arrQuestion2.add(createQues("Đạo diễn của vở nhạc kịch Kim Vân Kiều là ai?","Christophe Thiry","Johahn Bern&Alisa Karnet&Nguyễn Đăng Bình"));
        arrQuestions.add(arrQuestion2);

        //cau 3
        ArrayList<Questions> arrQuestion3 = new ArrayList<>();
        arrQuestion3.add(createQues("Vật liệu nào được dùng để rèn những cây kiếm Katana huyền thoại của Nhật Bản?","Tamahagane","Orihaco&Katanashi&Takashi"));
        arrQuestion3.add(createQues("Điền từ còn thiếu vào chỗ trống trong câu: ”Đục nước béo …”?","Cò","Vạc&Cá&Bò"));
        arrQuestions.add(arrQuestion3);

        //cau 4
        ArrayList<Questions> arrQuestion4 = new ArrayList<>();
        arrQuestion4.add(createQues("Việt Nam có chung biên giới với quốc gia nào dưới đây?","Trung Quốc","Thái Lan&Lào&Campuchia"));
        arrQuestion4.add(createQues("Đâu là tên một ngôi chùa nổi tiếng ở Hà Nam?","Tam Chúc","Trấn Quốc&Bổ Đà&Bái Đính"));
        arrQuestions.add(arrQuestion4);

        //cau 5
        ArrayList<Questions> arrQuestion5 = new ArrayList<>();
        arrQuestion5.add(createQues("Sóng biển thường được tạo ra do cái gì?","Gió","Nắng&Mưa&Sương mù"));
        arrQuestion5.add(createQues("Âm thanh có tần số lớn hơn 20KHz gọi là gì?","Siêu âm","Hạ âm&Quá âm&Cận âm"));
        arrQuestions.add(arrQuestion5);

        //cau 6
        ArrayList<Questions> arrQuestion6 = new ArrayList<>();
        arrQuestion6.add(createQues("Tác phẩm nào được coi là tác phẩm nổi tiếng nhất của Hector Malot?","Không gia đình","Đồi gió hú&Giã từ vũ khí&Miếng da lừa"));
        arrQuestion6.add(createQues("Ca sĩ nào không thuộc nhóm nhạc Big Bang của Hàn Quốc?","Jongkook","G-Dragon&T.O.P&Taeyang"));
        arrQuestions.add(arrQuestion6);

        //cau 7
        ArrayList<Questions> arrQuestion7 = new ArrayList<>();
        arrQuestion7.add(createQues("Đâu là một hợp kim của Nhôm?","Đuyra","Ferit&Alkanoid&Alumin"));
        arrQuestion7.add(createQues("Cầu thủ nào là vua phá lưới giải ngoại hạng Anh mùa giải 2019-2020?","Jamie Vardy","Aubameyang&Raheem Sterling&Mohamed Salah"));
        arrQuestions.add(arrQuestion7);

        //cau 8
        ArrayList<Questions> arrQuestion8 = new ArrayList<>();
        arrQuestion8.add(createQues("Thiên tài Albert Einstein đã từng được mời làm tổng thống của đất nước nào?","Israel","Latvia&Jordan&Bungari"));
        arrQuestion8.add(createQues("Điền vào chỗ trống: Giàu vì ..., sang vì vợ","bạn","bố&chú hàng xóm&mẹ"));
        arrQuestions.add(arrQuestion8);

        //cau 9
        ArrayList<Questions> arrQuestion9 = new ArrayList<>();
        arrQuestion9.add(createQues("Ngôi chùa nào được đúc hoàn toàn bằng đồng tại Việt Nam?","Chùa Đồng","Chùa Một Cột&Chùa Hương&Chùa Thiên Mụ"));
        arrQuestion9.add(createQues("Điền vào chỗ trống: Con cái phải yêu thương ...","cha mẹ","con đực&ông bà&ông hàng xóm"));
        arrQuestions.add(arrQuestion9);

        //cau 10
        ArrayList<Questions> arrQuestion10 = new ArrayList<>();
        arrQuestion10.add(createQues("Saturday trong tiếng Anh là thứ mấy trong tuần?","Thứ Bảy","Thứ Hai&Thứ Năm&Chủ Nhật"));
        arrQuestion10.add(createQues("Người Việt Nam đầu tiên bay vào vũ trụ?","Phạm Tuân","Khá Bảnh&Quang Hải&Trần Dần"));
        arrQuestions.add(arrQuestion10);

        //cau 11
        ArrayList<Questions> arrQuestion11 = new ArrayList<>();
        arrQuestion11.add(createQues("Ngọn núi nào cao nhất Nhật Bản?","Fuji","Phan-xi-păng&Everest&Aso"));
        arrQuestion11.add(createQues("Câu nói: \"Đầu tôi chưa rơi xuống đất, xin bệ hạ đừng lo\" là của ai?","Trần Thủ Độ","Trần Quốc Toản&Trần Quốc Tuấn&Trần Hưng Đạo"));
        arrQuestions.add(arrQuestion11);

        //cau 12
        ArrayList<Questions> arrQuestion12 = new ArrayList<>();
        arrQuestion12.add(createQues("Năm 1954, nước ta ký hiệp định nào với Pháp?","Giơ-ne-vơ","Paris&EVFTA&IPA"));
        arrQuestion12.add(createQues("Đất nước nào là quê hương của Santa Claus?","Phần Lan","Pháp&Úc&Mỹ"));
        arrQuestions.add(arrQuestion12);

        //cau 13
        ArrayList<Questions> arrQuestion13 = new ArrayList<>();
        arrQuestion13.add(createQues("Tim người gồm bao nhiêu ngăn?","4","3&2&5"));
        arrQuestion13.add(createQues("Thăng Long Hà Nội 1000 tuổi vào năm nào?","2010","2013&2012&2011"));
        arrQuestions.add(arrQuestion13);

        //cau 14
        ArrayList<Questions> arrQuestion14 = new ArrayList<>();
        arrQuestion14.add(createQues("Người ta thường gọi quốc gia nào là đất nước mặt trời mọc","Nhật Bản","Hàn Quốc&Việt Nam&Trung Quốc"));
        arrQuestion14.add(createQues("Ai là cha đẻ của thuyết tương đối?","Albert Einstein","Augustin-Louis Cauchy&Blaise Pascal&Pythagoras"));
        arrQuestions.add(arrQuestion14);

        //cau 15
        ArrayList<Questions> arrQuestion15 = new ArrayList<>();
        arrQuestion15.add(createQues("Người dựng nên nước Âu Lạc là ai?","Thục Phán","Trọng Thủy&An Dương Vương&Nguyễn Huệ"));
        arrQuestion15.add(createQues("Tên vũ khí của thổ dân Úc có khả năng bay lại về vị trí cũ?","Boomerang","Bom nguyên tử&Giáo&Lựu đạn"));
        arrQuestions.add(arrQuestion15);
    }

    private Questions createQues (String s1, String s2, String s3) {
        Questions q1 = new Questions();
        q1.setContent(s1);
        q1.setCorrectAnswer(s2);
        q1.setArrWrongAnswer(s3);
        return q1;
    }
}
