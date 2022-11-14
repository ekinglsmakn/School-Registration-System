<h4>Java Spring Boot ile Kodlanan Student Registration System Backend kodları</h4>

Kullanılan Teknolojiler/Veri Tabanı/Framework'ler
<ul>
<li>Java Spring Boot (2.6.7)</li>
<li>Spring Data JPA</li>
<li>Hibernate</li>
<li>Maven Plugin</li>
<li>RestFul</li>
<li>Lombok</li>
<li>MySql Database (8.0.31)</li>
<li>IDE: Intellij Idea </li>
</ul>

<h3>Proje Nasıl Çalışır?</h3>
<p>Projede Java 8 ve JDK 1.8 ile çalışılmıştır. Dolayısıyla JDK 1.8'in bilgisayarda kurulu olduğundan emin olmak gerekmektedir. Ayrıca MySql  Veri tabanı gerekmektedir. Projenin veri tabanı backup'ı aşağıda verilmiştir. Projede Intellij IDEA kullanılmıştır. Bilgisayarda kurulu olması gerekmektedir. Uygulama ayağa kaldırılmadan önce bir veri tabanı oluşturulup, indirilen "<i>school-registration-system-backup.sql</i>" isimli backup'ın, oluşturulan veri tabanına restore edilmesi gerekmektedir. Uygulama 8080 portunda çalışmaktadır.</p>

<a href="https://github.com/ekinglsmakn/School-Registration-System/blob/73ea2cee70b6c9fa65a04f7b44649815c426dc0f/school-registration-system-backup.sql" download>Veri Tabanını indirmek için tıklayınız</a>

<h3>END POINTLER</h3>
<h5>Course Tablosu Endpointleri;</h5>
<ul>
<li> POST : "http://localhost:8080/api/course/save" <i>Course tablosuna veri kaydeder</i></li>
<li> PUT : "http://localhost:8080/api/course/update/<b>id</b>" <i>Course tablosunda verilen id'ye göre güncelleme yapar. id endpointe verilmelidir. Veriler ise JSON olarak gönderilmelidir</i></li>
<li> GET : "http://localhost:8080/api/course/get" <i>Course tablosundan sadece course verilerini çeker</i></li>
<li> GET : "http://localhost:8080/api/course/filterByCourse" <i>Course tablosundan spesifik bir kursa kaydolan öğrencileri listeler. Id, postmanden query params olarak verilmelidir.
örnek key= id, value=1 </i></li>
<li> DELETE : "http://localhost:8080/api/course/delete/<b>id</b>" <i>verilen id'ye göre kurs verisi siler.</i></li>
<li> PUT "http://localhost:8080/api/course/softdelete" <i>Requestbody olarak verilen id'ye göre kurs verisi sof delete yapar. Yani enable = 0 atanır..</i></li>
</ul>

<h5>Student Tablosu Endpointleri;</h5>
<ul>
<li> POST : "http://localhost:8080/api/student/save" <i>Student tablosuna veri kaydeder</i></li>
<li> PUT : "http://localhost:8080/api/student/update/<b>id</b>" <i>Student tablosunda verilen id'ye göre güncelleme yapar. id endpointe verilmelidir. Veriler ise JSON olarak gönderilmelidir</i></li>
<li> GET : "http://localhost:8080/api/student/get" <i>Student tablosundan sadece student verilerini çeker</i></li>

<li> PUT : "http://localhost:8080/api/student/addCourse" <i>Student'lara Course ataması yapar. JSON olarak student id ve course id verilmelidir. örnek:{
    "student_id":5,
    "course_id_List": [1,2]
}</i></li>
<li> GET : "http://localhost:8080/api/student/registered/<b>id</b>" <i>Spesifik bir öğrencinin kurs ve öğrenci bilgilerini getirir</i></li>
<li> GET "http://localhost:8080/api/student/unregistered" <i>Hiçbir kursa kaydolmamış öğrencileri getirir</i></li>
</ul>



