-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.4.22-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             12.0.0.6468
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for qlshopthoitrang
CREATE DATABASE IF NOT EXISTS `qlshopthoitrang` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `qlshopthoitrang`;

-- Dumping structure for table qlshopthoitrang.chitiethoadon
CREATE TABLE IF NOT EXISTS `chitiethoadon` (
  `MaHD` int(11) NOT NULL,
  `MaSP` int(11) NOT NULL,
  `SoLuong` int(11) NOT NULL,
  `DonGia` decimal(18,0) NOT NULL,
  PRIMARY KEY (`MaHD`,`MaSP`),
  KEY `MaSP` (`MaSP`),
  CONSTRAINT `chitiethoadon_ibfk_1` FOREIGN KEY (`MaHD`) REFERENCES `hoadon` (`MaHD`),
  CONSTRAINT `chitiethoadon_ibfk_2` FOREIGN KEY (`MaSP`) REFERENCES `sanpham` (`MaSP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Dumping data for table qlshopthoitrang.chitiethoadon: ~0 rows (approximately)
DELETE FROM `chitiethoadon`;

-- Dumping structure for table qlshopthoitrang.hoadon
CREATE TABLE IF NOT EXISTS `hoadon` (
  `MaHD` int(11) NOT NULL AUTO_INCREMENT,
  `NgayDat` date NOT NULL,
  `NgayGiao` date NOT NULL,
  `TinhTrang` varchar(50) CHARACTER SET utf8 NOT NULL,
  `MaKH` int(11) NOT NULL,
  PRIMARY KEY (`MaHD`),
  KEY `MaKH` (`MaKH`),
  CONSTRAINT `hoadon_ibfk_1` FOREIGN KEY (`MaKH`) REFERENCES `khachhang` (`MaKH`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Dumping data for table qlshopthoitrang.hoadon: ~0 rows (approximately)
DELETE FROM `hoadon`;

-- Dumping structure for table qlshopthoitrang.khachhang
CREATE TABLE IF NOT EXISTS `khachhang` (
  `MaKH` int(11) NOT NULL AUTO_INCREMENT,
  `TenKH` varchar(50) CHARACTER SET utf8 NOT NULL,
  `NgaySinh` datetime NOT NULL,
  `GioiTinh` varchar(5) CHARACTER SET utf8 NOT NULL,
  `TaiKhoan` varchar(50) NOT NULL,
  `MatKhau` varchar(70) NOT NULL,
  `DiaChi` varchar(50) CHARACTER SET utf8 NOT NULL,
  `Email` varchar(50) NOT NULL,
  `SDT` char(11) NOT NULL,
  `TrangThai` tinyint(4) DEFAULT 1,
  PRIMARY KEY (`MaKH`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table qlshopthoitrang.khachhang: ~1 rows (approximately)
DELETE FROM `khachhang`;
INSERT INTO `khachhang` (`MaKH`, `TenKH`, `NgaySinh`, `GioiTinh`, `TaiKhoan`, `MatKhau`, `DiaChi`, `Email`, `SDT`, `TrangThai`) VALUES
	(1, 'Long', '2022-09-22 22:31:30', 'Nam', 'long', '$2a$10$GW3P6Lj5.pPVbXZm2tGxxuicJYnYSvjW2QJdE6B24P.6p0AS0WMBm', '135', '123@gmail.com', '123', 1),
	(2, 'no', '2022-09-23 00:05:38', 'nam', 'nam', '$2a$10$GW3P6Lj5.pPVbXZm2tGxxuicJYnYSvjW2QJdE6B24P.6p0AS0WMBm', 'no', 'no@gmail.com', '123', 1);

-- Dumping structure for table qlshopthoitrang.loaisanpham
CREATE TABLE IF NOT EXISTS `loaisanpham` (
  `MaLoaiSP` int(11) NOT NULL AUTO_INCREMENT,
  `TenLoaiSP` varchar(50) CHARACTER SET utf8 NOT NULL,
  `Slug` varchar(250) CHARACTER SET utf8 NOT NULL,
  `TrangThai` tinyint(4) NOT NULL DEFAULT 1,
  PRIMARY KEY (`MaLoaiSP`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table qlshopthoitrang.loaisanpham: ~15 rows (approximately)
DELETE FROM `loaisanpham`;
INSERT INTO `loaisanpham` (`MaLoaiSP`, `TenLoaiSP`, `Slug`, `TrangThai`) VALUES
	(1, 'Áo thun nam', 'ao-thun-nam', 1),
	(2, 'Áo thun nữ', 'ao-thun-nư', 1),
	(3, 'Áo sơ mi nam', 'ao-so-mi-nam', 1),
	(4, 'Áo sơ mi nữ', 'ao-so-mi-nu', 1),
	(5, 'Đầm nữ', 'dam-nu', 1),
	(6, 'Chân váy', 'chan-vay', 1),
	(7, 'Quần short nữ', 'quan-short-nu', 1),
	(8, 'Quần jean nữ', 'quan-jean-nu', 1),
	(9, 'Quần thun nữ', 'quan-thun-nu', 1),
	(10, 'Quần jogger nữ', 'quan-jogger-nu', 1),
	(11, 'Quần short nam', 'quan-short-nam', 1),
	(12, 'Quần kaki nam', 'quan-kaki-nam', 1),
	(13, 'Quần jean nam', 'quan-jean-nam', 1),
	(14, 'Quần tây nam', 'quan-tay-nam', 1),
	(15, 'Quần jogger nam', 'quan-jogger-nam', 1);

-- Dumping structure for table qlshopthoitrang.nhacungcap
CREATE TABLE IF NOT EXISTS `nhacungcap` (
  `MaNCC` int(11) NOT NULL AUTO_INCREMENT,
  `TenNCC` varchar(50) CHARACTER SET utf8 NOT NULL,
  `DiaChi` varchar(50) CHARACTER SET utf8 NOT NULL,
  `SDT` char(13) NOT NULL,
  `TrangThai` tinyint(4) NOT NULL DEFAULT 1,
  PRIMARY KEY (`MaNCC`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table qlshopthoitrang.nhacungcap: ~1 rows (approximately)
DELETE FROM `nhacungcap`;
INSERT INTO `nhacungcap` (`MaNCC`, `TenNCC`, `DiaChi`, `SDT`, `TrangThai`) VALUES
	(1, 'Công ty may mặc', '114 Lê Trọng Tấn Quận Tân Phú', '0123456789', 1);

-- Dumping structure for table qlshopthoitrang.sanpham
CREATE TABLE IF NOT EXISTS `sanpham` (
  `MaSP` int(11) NOT NULL AUTO_INCREMENT,
  `TenSP` varchar(250) CHARACTER SET utf8 NOT NULL,
  `MoTa` varchar(700) CHARACTER SET utf8 DEFAULT NULL,
  `GioiTinh` varchar(5) CHARACTER SET utf8 NOT NULL,
  `GiaBan` decimal(18,0) NOT NULL,
  `GiaNhap` decimal(18,0) NOT NULL,
  `Anh` varchar(50) CHARACTER SET utf8 DEFAULT 'anh.png',
  `Slug` varchar(500) CHARACTER SET utf8 NOT NULL,
  `MaLoaiSP` int(11) NOT NULL,
  `MaNCC` int(11) NOT NULL,
  `SoLuongTon` int(11) NOT NULL,
  `TrangThai` tinyint(4) NOT NULL DEFAULT 1,
  PRIMARY KEY (`MaSP`),
  KEY `MaLoaiSP` (`MaLoaiSP`),
  KEY `MaNCC` (`MaNCC`),
  CONSTRAINT `sanpham_ibfk_1` FOREIGN KEY (`MaLoaiSP`) REFERENCES `loaisanpham` (`MaLoaiSP`),
  CONSTRAINT `sanpham_ibfk_2` FOREIGN KEY (`MaNCC`) REFERENCES `nhacungcap` (`MaNCC`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table qlshopthoitrang.sanpham: ~42 rows (approximately)
DELETE FROM `sanpham`;
INSERT INTO `sanpham` (`MaSP`, `TenSP`, `MoTa`, `GioiTinh`, `GiaBan`, `GiaNhap`, `Anh`, `Slug`, `MaLoaiSP`, `MaNCC`, `SoLuongTon`, `TrangThai`) VALUES
	(1, 'ÁO THUN NAM NGẮN TAY CỔ TRỤ', 'ÁO THUN NAM NGẮN TAY CỔ TRỤ THUN COTTON SỌC NGANG PHỐI 2 MÀU ĐẸP MẮT<br>Chất liệu: Vải 100% thun cotton mềm mịn, thấm hút mồ hôi tốt', 'Nam', 145000, 100000, 'N\'ao-thun-nam-ngan-tay.jpg', 'ao-thun-nam-ngan-tay-co-tru', 1, 1, 100, 1),
	(2, 'ÁO THUN NAM NGẮN TAY CỔ TRỤ', 'ÁO THUN NAM CỔ TRỤ NGẮN TAY VIỀN CỔ IN LOGO MẪU MỚI<br>Chất liệu: Vải 100% thun cotton mềm mịn, thấm hút mồ hôi tốt', 'Nam', 155000, 100000, 'ao-thun-nam-co-tru-ngan-tay.jpg', 'ao-thun-nam-ngan-tay-co-tru-1', 1, 1, 100, 1),
	(3, 'ÁO THUN NAM HÌNH HỔ 3D', 'ÁO THUN NAM HÌNH HỔ 3D: Chất vải thun 3D mịn lạnh, thấm hút mồ hôi nhanh giúp các chàng luôn thoải mái khi vận động, chơi các trò chơi thể thao, thể chất. Bên cạnh đó là thiết kế mạnh mẽ với hình hổ ấn tượng mang đến cho các chàng sự sang trọng, trẻ trung  để các chàng luôn sẵn sàng xuất hiện trước các nàng mà không lo thiếu sự thu hút.<br>Chất liệu: VẢI THUN 3D CO GIÃN CAO CẤP', 'Nam', 155000, 100000, 'ao-thun-nam-hinh-ho-3d.jpg', 'ao-thun-nam-hinh-ho-3d', 1, 1, 100, 1),
	(4, 'SƠ MI NAM HÀN QUỐC TRẺ TRUNG', 'SƠ MI NAM HÀN QUỐC TRẺ TRUNG: Chất vải dày dặn cao cấp, đặc biệt với những sọc nhỏ tinh tế cùng dáng áo chuẩn để các chàng tự tin khoe dáng. Bên cạnh đó là chất màu lên tông chuẩn để các chàng lựa chọn phong cách cho mình thật thoải mái. Ngoài ra, với thiết kế tay dài thanh lịch, chiếc áo sẽ là bạn đồng hành cùng các chàng trai trong những ngày lên công tay hay trong những buổi gặp khách hàng.<br>Chất liệu: VẢI KAKI MỀM', 'Nam', 240000, 100000, 'so-mi-nam-han-quoc.jpg', 'so-mi-nam-han-quoc-tre-trung', 3, 1, 100, 1),
	(5, 'SƠ MI NAM CARO Ô LỚN', 'SƠ MI NAM CARO Ô LỚN: Chất vải kate dày dặn cao cấp, dáng áo chuẩn để các chàng tự tin khoe dáng. Bên cạnh đó là họa tiết caro ôn lớn đối xứng sang trọng nhưng không kém phần tươi trẻ kết hợp với thiết kế tay dài thanh lịch, chiếc áo sẽ là bạn đồng hành cùng các chàng trai trong những ngày lên công ty hay trong những buổi gặp khách hàng.<br>Chất liệu: VẢI KATE DÀY MỊN', 'Nam', 220000, 100000, 'so-mi-nam-caro.jpg', 'so-mi-nam-caro-o-lon', 3, 1, 100, 1),
	(6, 'ÁO SƠ MI NAM LOANG MÀU THỜI THƯỢNG', 'ÁO SƠ MI NAM LOANG MÀU THỜI THƯỢNG: Chất vải dày dặn cao cấp, dáng áo chuẩn để các chàng tự tin khoe dáng. Bên cạnh đó là chất màu lên tông chuẩn để các chàng lựa chọn phong cách cho mình thật thoải mái. Ngoài ra, với thiết kế tay dài thanh lịch nhưng không mất đi sự trẻ trung pha chút nổi loạn với việc kết hợp màu loang mới mẻ.<br>Chất liệu: KATE BÓNG CAO CẤP', 'Nam', 235000, 100000, 'ao-so-mi-nam-loang-mau.jpg', 'ao-so-mi-loang-mau-thoi-thuong', 3, 1, 100, 1),
	(7, 'QUẦN SHORT JEANS CÓ KHUY ĐỘC ĐÁO', 'QUẦN SHORT JEANS CÓ KHUY ĐỘC ĐÁO: Chất vải jeans cao cấp xuất khẩu vừa dày dặn, nhẹ mịn vừa co giãn vừa phải giúp người mang dế chịu, tự tin. Bên cạnh đó còn là thiết kế trẻ trung, năng động và đầy độc đáo với khuy sản phẩm lạ mắt.<br>Chất liệu: VẢI JEANS CAO CẤP XUẤT KHẨU', 'Nam', 180000, 100000, 'quan-short-jeans-co-khuy.jpg', 'quan-short-jeans-co-khuy-doc-dao', 11, 1, 100, 1),
	(8, 'QUẦN ĐÙI NAM SỐ 69 CAO CẤP', 'QUẦN ĐÙI NAM SỐ 69 CAO CẤP: Thiết kế trẻ trung, năng động với thiết kế săn lai ống giúp các trai trông năng động hơn. Bên cạnh đó chất vải jenas dày dặn mang đến sự tự tin cho các chàng trong việc hoạt động vui chơi mà không lo các sự cố khó xửa xảy ra.<br>Chất liệu: VẢI JEANS CAO CẤP XUẤT KHẨU', 'Nam', 185000, 100000, 'quan-dui-nam-so-69-cao-cap.jpg', 'quan-dui-nam-so-69-cao-cap', 11, 1, 100, 1),
	(9, 'QUẦN SHORT JEANS NAM KẾT HỢP HỌA TIẾT CHIBI', 'QUẦN SHORT JEANS NAM KẾT HỢP HỌA TIẾT CHIBI ĐÁNG YÊU: Chất vải jeans cao cấp nhập khẩu Thái Lan mang đến cho người mặc sự thoải mái và tin tưởng bởi chất vải dày dặn, mịn nhẹ. bên cạnh đó ngoài những nét cắt rách táo bạo là họa tiết chibi mang đến sự trẻ trung, nắng động cho người mang.<br>Chất liệu: VẢI JEANS NHẬP KHẨU THÁI LAN', 'Nam', 180000, 100000, 'quan-short-jeans-nam.jpg', 'quan-short-jeans-nam-ket-hop-hoa-tiet-chibi', 11, 1, 100, 1),
	(10, 'QUẦN JEANS NAM CAO CẤP THIẾT KẾ KẾT HỢP VẢI MẪU', 'QUẦN JEANS NAM CAO CẤP THIẾT KẾ KẾT HỢP VẢI MẪU: Chất vải cao cấp xuất khẩu dày dặn, lên form chuẩn dáng để các chàng thoải mái khoe body. Bên cạnh đó là thiết kế phong cách đường phố mạnh mẽ, phá cách với những nét cắt, xước táo bạo, độc đáo mà chỉ riêng sản phẩm có.<br>Chất liệu: VẢI JEANS NAM CAO CẤP NHẬP KHẨU', 'Nam', 265000, 100000, 'quan-jeans-nam-cao-cap.jpg', 'quan-jeans-nam-cao-cap-thiet-ke-hop-vai-mau', 13, 1, 100, 1),
	(11, 'QUẦN JEANS NAM NHẤN GỐI TRÁI TINH TẾ', 'QUẦN JEANS NAM NHẤN GỐI TRÁI TINH TẾ: Chất vải cao cấp xuất khẩu dày dặn, lên form chuẩn dáng để các chàng thoải mái khoe body. Bên cạnh đó là thiết kế phong cách đường phố mạnh mẽ, phá cách với những nét cắt, xước táo bạo, độc đáo mà chỉ riêng sản phẩm có.<br>Chất liệu: VẢI JEANS NHẬP KHẨU HÀN QUỐC', 'Nam', 270000, 100000, 'quan-jeans-nam-nhan-goi-trai.jpg', 'quan-jeans-nam-nhan-goi-trai-tinh-te', 13, 1, 100, 1),
	(12, 'QUẦN JEAN NAM PHONG CÁC ĐƯỜNG PHỐ MỚI', 'QUẦN JEAN NAM PHONG CÁC ĐƯỜNG PHỐ MỚI: Thiết kế phá cách, theo xu hướng đường phố đem đến cho các chàng trai sự năng động, pha chút nổi loạn làm các chàng trai trông thật sự nổi bật cũng như tự tin thể hiện phong cách của bản thân trong mọi cuộc vui.<br>Chất liệu: VẢI JEANS CAO CẤP XUẤT KHẨU', 'Nam', 265000, 100000, 'quan-jean-nam.jpg', 'quan-jean-nam-phong-cac-duong-pho-moi', 13, 1, 100, 1),
	(13, 'QUẦN KAKI LƯNG PHỐI DÂY SỌC QK005 MÀU XANH ĐEN', 'Sớ vải dệt xéo nổi lên khá lạ mắt tạo nên một sản phẩm dày dặn, bền bỉ và ít nhăn, chất liệu cao cấp mang đến sự thoáng mát, thấm hút mồ hôi cao.\n<br>- Quần co giãn nhẹ  nhờ có thành phần spandex giúp người mặc cảm thấy thoải mái, dễ chịu hơn.\n<br>- Sản phẩm được xử lý wash mềm, đốt lông nên đảm bảo hạn chế co rút, xù lông và bền màu.\n<br>- Phần phối dây dệt sọc ở lưng quần làm điểm nhấn mới lạ đầy ấn tượng nhưng vẫn giữ được nét thanh lịch, thời thượng cho phái mạnh.<br>Chất liệu: Khaki 98% cotton 2% spandex twill stretch.', 'Nam', 355000, 100000, 'quan-kaki-nam-lung-phoi-day-soc.png', 'quan-kaki-lung-phoi-day-soc-qk005-mau-xanh-den', 12, 1, 100, 1),
	(14, 'QUẦN KAKI LƯNG PHỐI DÂY SỌC QK005 MÀU CÀ PHÊ', 'Sớ vải dệt xéo nổi lên khá lạ mắt tạo nên một sản phẩm dày dặn, bền bỉ và ít nhăn, chất liệu cao cấp mang đến sự thoáng mát, thấm hút mồ hôi cao.\n<br>- Quần co giãn nhẹ  nhờ có thành phần spandex giúp người mặc cảm thấy thoải mái, dễ chịu hơn.\n<br>- Sản phẩm được xử lý wash mềm, đốt lông nên đảm bảo hạn chế co rút, xù lông và bền màu.\n<br>- Phần phối dây dệt sọc ở lưng quần làm điểm nhấn mới lạ đầy ấn tượng nhưng vẫn giữ được nét thanh lịch, thời thượng cho phái mạnh.<br>Chất liệu: Khaki 98% cotton 2% spandex twill stretch.', 'Nam', 355000, 100000, 'quan-kaki-nam.png', 'quan-kaki-lung-phoi-day-soc-qk005-mau-ca-phe', 12, 1, 100, 1),
	(15, 'QUẦN KAKI CÓ NẮP TÚI SAU QK003 MÀU XÁM', 'Mềm mại, độ bền cao, hút ẩm và thấm hút mồ hôi tốt. Thiết kế căn bản dễ mix&match nhiều dạng quần áo và phong cách.<br>Chất liệu: 98% cotton, 2% spandex.', 'Nam', 310000, 100000, 'quan-nam-kaki-co-nap-tui-sau.png', 'quan-kaki-co-nap-tui-sau-qk003-mau-xam', 12, 1, 100, 1),
	(16, 'QUẦN TÂY NAZAFU QT006 MÀU XANH ĐEN', 'Chất vải mềm mại, độ bền cao, hút ẩm và thấm hút mồ hôi tốt. Họa tiết kẻ caro Glen plaid rất "đa dụng", thanh nhã. <br>Chất liệu: 73% polyester, 26% rayon, 1% spandex.', 'Nam', 427000, 100000, 'quan-tay-nazafu.png', 'quan-tay-nazafu-qt006-mau-xanh-den', 14, 1, 100, 1),
	(17, 'QUẦN TÂY CĂN BẢN FORM SLIMFIT QT015', 'Quần slimfit tôn dáng thon gọn trong thiết kế trơn căn bản. Chất liệu thấm hút tốt, độ bền cao tạo cảm giác thoải mái cho người mặc.<br>Chất liệu: 68% polyester,rayon 29%, 3% spandex.', 'Nam', 382000, 100000, 'quan-tay-phoi-day-det.png', 'quan-tay-can-ban-form-slimfit-qt015', 14, 1, 100, 1),
	(18, 'QUẦN TÂY XẾP LY FORM SLIMFIT QT007 MÀU XÁM CHUỘT ĐẬM', 'Chống nhăn, co dãn nhẹ. Thiết kế trên chất vải bóng mịn, sở hữu độ bền màu cao tạo phong thái lịch thiệp và tinh tế cho người mặc.<br>Chất liệu: 83% polyester, 15% rayon, 2% spandex.', 'Nam', 346000, 100000, 'quan-tay-xep-ly-form.png', 'quan-tay-xep-ly-form-slimfit-qt007-mau-xam-chuot-dam', 14, 1, 100, 1),
	(19, 'QUẦN JOGGER LƯNG THUN CÀI NÚT J004 MÀU XÁM XANH', 'Mềm mịn, có độ rũ nhẹ. Độ bền màu cao, thấm hút mồ hôi tốt. Co giãn nhẹ, hạn chế nhăn tạo cảm giác thoải mái tối đa trong mọi hoạt động<br>Chất liệu: 83% polyester, 15% rayon, 2% spandex.', 'Nam', 337000, 100000, 'quan-tay-lung-thun-cai-nut.png', 'quan-jogger-lung-thun-cai-nut-j004-mau-xam-xanh', 15, 1, 100, 1),
	(20, 'QUẦN JOGGER JEAN J13 MÀU XANH ĐEN', 'Đậm chất jeans nhưng là jogger năng động & cá tính. Jogger đơn giản với thiết kế bo lưng & bo lai mới tạo điểm nhấn cho quần luôn thoải mái, trẻ trung, jogger thực sự thuộc về các chàng trai ưu thích sự di chuyển.<br>Chất liệu: 98% cotton, 2% spandex', 'Nam', 400000, 100000, 'quan-jogger-jean-mau-xanh-bien.jpg', 'quan-jogger-jean-j13-mau-xanh-den', 15, 1, 100, 1),
	(21, 'QUẦN JOGGER TÚI ĐẮP J001 MÀU ĐEN', 'Co giãn vừa phải, bền màu, ít nhăn. Form dáng thoải mái, năng động với 2 túi đắp bên hông quần tạo phong thái trẻ trung và phóng khoáng.<br>Chất liệu: 65% polyester, 32% rayon, 3% spandex.', 'Nam', 346000, 100000, 'quan-jogger-kaki-bo-lai.png', 'quan-jogger-tui-dap-j001-mau-den', 15, 1, 100, 1),
	(22, 'ÁO THUN NỮ TRẺ TRUNG MỚI', 'ÁO THUN NỮ TRẺ TRUNG MỚI: Với thiết kế trẻ trung với viền màu nổi bật cùng hình ảnh bắt mắt bên cạnh đó là chất vải cao cấp, lên màu, lên dáng chuẩn như các cô gái muốn giúp các nàng luôn tự tin tỏa sáng và thoải mái khi mang dù cho là cả ngày dài hoạt động.<br>Chất liệu: VẢI DA CÁ CAO CẤP', 'Nữ', 125000, 100000, 'ao-thun-nu-tre-trung-moi.jpg', 'ao-thun-nu-tre-trung-moi', 2, 1, 100, 1),
	(23, 'ÁO THUN NỮ HIỆN ĐẠI CAO CẤP', 'ÁO THUN NỮ HIỆN ĐẠI CAO CẤP: Thiết kế hiện đại với kiểu tay phồng nhún viền tinh tế, bắt mắt bên cạnh đó là chất vải thun dày dặn cao cấp không chỉ lên màu chuẩn mà còn lên dáng chuẩn như các nàng muốn giúp các nàng luôn tự tin tỏa sáng và thoải mái khi mang dù cho là cả ngày dài hoạt động.<br>Chất liệu: VẢI THUN CAO CẤP DÀY DẶN', 'Nữ', 140000, 100000, 'ao-thun-nu-hien-dai-cao-cap.jpg', 'ao-thun-nu-hien-dai-cao-cap', 2, 1, 100, 1),
	(24, 'ÁO THUN NỮ SỌC MÀU NĂNG ĐỘNG', 'ÁO THUN NỮ SỌC MÀU NĂNG ĐỘNG: Thiết kế hiện đại với những sọc màu bắt mắt, sự kết hợp những màu sắc nổi bật đi cùng nhau tạo nên sự khác biệt mang phong cách Hàn Quốc bên cạnh đó là chất vải cao cấp, lên màu, lên dáng chuẩn như ming muốn giúp các nàng luôn tự tin tỏa sáng và thoải mái khi mang dù cho là cả ngày dài hoạt động.<br>Chất liệu: VẢI NHŨ NHẬP KHẨU', 'Nữ', 140000, 100000, 'ao-thun-nu-soc-mau-nang-dong.jpg', 'ao-thun-nu-doc-mau-nang-dong', 2, 1, 100, 1),
	(25, 'SƠ MI NỮ KIỂU CỔ VUÔNG HIỆN ĐẠI', 'SƠ MI NỮ KIỂU CỔ VUÔNG HIỆN ĐẠI: Chất vải voan mềm mịn cùng với chất len gân co giãn mang đến vẻ đẹp dịu dàng nữ tính cùng sự thoải mái, dễ chịu khi hoạt động cả ngày dài. Đặc biệt là thiết kế hiện đại, mang nét gợi cảm giúp người mang nổi bật với nét đẹp hiện đại thời thượng.<br>Chất liệu: VẢI VOAN MỀM KẾT HỢP LEN GÂN MỎNG', 'Nữ', 210000, 100000, 'so-mi-nu-kieu-co-vuong-hien-dai.jpg', 'so-mi-nu-kieu-co-vuong-hien-dai', 4, 1, 100, 1),
	(26, 'ÁO SƠ MI NỮ SỌC TAY LỬNG THIẾT KẾ ĐỘC ĐÁO', 'ÁO SƠ MI NỮ SỌC TAY LỬNG THIẾT KẾ ĐỘC ĐÁO: Chất liệu kate mềm mịn cao cấp thướt tha, nhẹ nhàng, dễ chịu. Kiểu dáng áo cổ bẻ, tay lửng thời trang, mang nền vải sọc vân nhỏ đậm chất lịch sự cho bạn gái thêm phần trang nhã, lịch sự và đầy nữ tính. Chiếc áo không chỉ thích hợp cho những ngày đến cơ quan, công sở mà còn là một sự lựa chọn khá hoàn hảo cho những buổi đầu hẹn hò khi muôn xuất hiện với hình ảnh trang nhã.<br>Chất liệu: VẢI KATE MỀM NHẸ CAO CẤP', 'Nữ', 220000, 100000, 'ao-so-mi-nu-soc-tay-lung.jpg', 'ao-so-mi-nu-soc-tay-lung-thiet-ke-doc-dao', 4, 1, 100, 1),
	(27, 'ÁO SƠ MI NỮ TRƠN FROM ÁO ĐỘC ĐÁO', 'ÁO SƠ MI NỮ TRƠN FROM ÁO ĐỘC ĐÁO: Với chất vải kate cao cấp mềm mịn và thoáng khí giúp người mang thoải mái khi hoạt động cả ngày dù trong thời tiết nắng nóng. Bên cạnh đó là from áo độc đáo mang tới vẻ đẹp cá tính, hiện đại giúp các nàng trông thật nổi bật trong mọi cuộc vui.<br>Chất liệu: VẢI KATE CAO CẤP', 'Nữ', 210000, 100000, 'ao-so-mi-nu-tron-from-ao.jpg', 'ao-so-mi-nu-tron-form-ao-doc-dao', 4, 1, 100, 1),
	(28, 'ĐẦM NỮ CỔ CHỮ U XẺ TÀ SÀNH ĐIỆU', 'ĐẦM NỮ CỔ CHỮ U XẺ TÀ SÀNH ĐIỆU\',N\'ĐẦM NỮ CỔ CHỮ U XẺ TÀ SÀNH ĐIỆU: Với chất vải cao cấp nhập khẩu từ Thái Lan, vải dày dặn, thấm hút mồ hôi tốt. Bên cạnh đó thiết kế sang trọng với cổ chữ U và xẻ tà quyến rũ giúp người mặc trông thật trẻ trung năng động và đầy tự tin. <br>Chất liệu: VẢI KATE CO GIÃN NHẬP KHẨU THÁI LAN', 'Nữ', 240000, 100000, 'dam-nu-co-chu-u-xe-ta-sanh-dieu.jpg', 'dam-nu-co-chu-u-xe-ta-xanh-dieu', 5, 1, 100, 1),
	(29, 'ĐẦM HOA 2 LỚP XẾP EO MS 48B8245', 'Đầm 2 lớp dáng chữ A, cổ tròn. Xếp nếp ở mặt trước phần eo. Tay lỡ. Cài bằng khóa kéo ẩn sau lưng. Vải họa tiết hoa thu hút. Kiểu dáng chữ A, ôm nhẹ với độ dài trên gối cùng phần tay lỡ giúp che đi hầu hết các khuyết điểm cơ thể. Bên cạnh đó chất liệu thô co giãn nhẹ, bền màu, ít nhăn mang lại cảm giác thoải mái khi mặc. <br>Chất liệu: Thô', 'Nữ', 645000, 100000, 'damhoa2lop.jpg', 'dam-hoa-2-lop-xep-eo-ms-48b8245', 5, 1, 100, 1),
	(30, 'ĐẦM LỤA CHẤM BI 2 LỚP MS 48M4844', 'Đầm lụa chấm bi, cổ chữ V vạt trước đáp chéo được xếp nếp tinh tế, tay ngắn. Dáng ôm. Eo chiết kèm đai cùng màu. Gấu sau xẻ. Cài bằng khóa kéo ẩn sau lưng. Những đường xếp ly ở phần chân váy giúp che được hết những khuyết điểm của cô nàng mảnh khảnh và mang đến sự tinh nghịch, trẻ trung, phá cách mà không kém phần quyến rũ cho phái đẹp. <br>Chất liệu: Lụa', 'Nữ', 745000, 100000, 'damluachambi.jpg', 'dam-lua-cham-bi-2-lop-ms-48m4844', 5, 1, 100, 1),
	(31, 'Chân Váy Jean Rách', 'Màu sắc: Đen - Trắng. Kiểu dáng: Chất kaki jeans Co giãn, dày dặn, không xù lông và có thể giặt máy. Size : Size: S (dưới 45kg), M(46-50kg), L(51-55kg). Mục đích sử dụng: dạo phố. đi chơi, đi học hoặc đi làm', 'Nữ', 119000, 100000, 'chan-vay-jean-rach.jpg', 'chan-vay-jean-rach', 6, 1, 100, 1),
	(32, 'Chân Váy Jean Ngắn', 'Màu sắc: Đen - Trắng. Kiểu dáng: Chất kaki jeans Co giãn, dày dặn, không xù lông và có thể giặt máy. Size : Size: S (dưới 45kg), M(46-50kg), L(51-55kg). Mục đích sử dụng: dạo phố. đi chơi, đi học hoặc đi làm', 'Nữ', 129000, 100000, 'chan-vay-jean-om.jpg', 'chan-vay-jean-ngan', 6, 1, 100, 1),
	(33, 'Chân Váy Xếp Ly', 'Những chiếc Chân Váy Xếp Ly mềm mại với chiều dài trên gối là lựa chọn dành riêng cho các quý cô yêu thích phong cách lãng mạn. Vì sao ư? vì chúng đơn giản nhưng không hề nhàm chán, kín đáo nhưng lại quyến rũ một cách lạ thường. Sự bắt cặp quá đỗi hoàn hảo này là bởi những đường ly thanh mảnh mềm mại đến tinh tế sẽ khiến cho các quý cô trông thật duyên dáng và chiều dài chỉ đến ngang bắp chân sẽ khiến cho mỗi bước đi trông thật uyển chuyển và gợi cảm. Chiếc váy chính là món đồ có thể kết hợp ăn ý cùng áo len chui đầu, áo phông, sơ mi dáng rộng và một đôi giày/sandals cao gót thanh mảnh.', 'Nữ', 144000, 100000, 'chan-vay-xep-ly.png', 'chan-vay-xep-ly', 6, 1, 100, 1),
	(34, 'SHORT LƯNG THUN VIỀN SỌC', 'Mix- Max phối cùng các kiểu áo thun thời trang, croptop phá cách, áo ba lỗ mát mẻ. Lưng thun dây rút tạo cảm giác thoải mái và tự tin cho người mặc. Short viền sọc là style đầy mới mẻ dành cho tủ đồ ngày hè của bạn gái.', 'Nữ', 145000, 100000, 'quan-shorrt-nu-lung-thun-vien-soc.png', 'short-lung-thun-vien-soc', 7, 1, 100, 1),
	(35, 'Quần Short Jean Nhung', 'Quần Short Jean Rách Nhung cách điệu với thiết kế chuẩn form co giãn, đẹp mắt, dễ thương, kiểu dáng đơn giản. Dáng quần vừa vặn nhiều vóc người. Có thể kết hợp cùng nhiều thiết kế áo kiểu khác nhau.', 'Nữ', 170000, 100000, 'quan-shorrt-nu-lung-thun-vien-soc.png', 'quan-short-jean-nhung', 7, 1, 100, 1),
	(36, 'Quần Short 2 Túi Lai V', 'Mix- Max phối cùng các kiểu áo thun thời trang, croptop phá cách, áo ba lỗ mát mẻ. Lưng thun dây rút tạo cảm giác thoải mái và tự tin cho người mặc. Short viền sọc là style đầy mới mẻ dành cho tủ đồ ngày hè của bạn gái.', 'Nữ', 149000, 100000, 'quan-short-2-tui-lai.png', 'quan-short-2-tui-lai-v', 7, 1, 100, 1),
	(37, 'QUẦN JEANS NỮ ỐNG SUÔNG CÁCH ĐIỆU CÁ TÍNH', 'QUẦN JEANS NỮ ỐNG SUÔNG CÁCH ĐIỆU CÁ TÍNH: Với những cô nàng đã cực kỳ đam mê với mẫu quần ống suông nhưng thấy nhàm chán với mẫu basic ban đầu thì chắc chắn sản phẩm sẽ làm các nàng hài lòng với sự nhấn nhá, cách điệu với đường cắt dứt khoác, mạnh mẽ lần lượt tại hông và bắp chân. Đặc biệt là ống quần với thiết kế cắt thuần túy tại nên những tua rua tự nhiên mang đến sự năng động cho các nàng.<br>Chất liệu: VẢI JEANS DÀY MỊN', 'Nữ', 220000, 100000, 'quan-jeans-nu-ong-suong-cach-dieu-ca-tinh.jpg', 'quan-jean-nu-ong-suong-cach-dieu-ca-tinh', 8, 1, 100, 1),
	(38, 'QUẦN JEANS NỮ NHẤN CHỮ ĐÙI CÁ TÍNH', 'QUẦN JEANS NỮ NHẤN CHỮ ĐÙI CÁ TÍNH : Chất vải jeans cao cấp, tuyển chọn đảm bảo được form quần và màu lên chuẩn cùng với thiết kế hiện đại kèm theo sự trẻ trung thanh lịch để các cô gái luôn có thể tự tin diện ở mọi nơi mà không lo rằng sẽ không phù hợp và chắc chắn là các cô gái sẽ thật tỏa sáng, nổi bật với phong cách nhẹ nhàng.<br>Chất liệu: VẢI JEANS DÀY DẶN XUẤT KHẨU', 'Nữ', 210000, 100000, 'quan-jeans-nu-nhan-chu-dui-ca-tinh.jpg', 'quan-jean-nu-nhan-chu-dui-ca-tinh', 8, 1, 100, 1),
	(39, 'QUẦN JEANS NỮ WASH ỐNG ĐỘC ĐÁO', 'QUẦN JEANS NỮ WASH ỐNG ĐỘC ĐÁO: Chất liệu vải jeans dày dặn cao cấp, chắc chắn cho bạn yên tâm khi hoạt động mạnh, có khả năng thấm hút các giọt mồ hôi và co giãn tốt. Kiểu dáng thiết kế ống ôm sang trọng, khoe dáng, luôn luôn được những bạn gái yêu mến trong mọi phong cách thời trang.<br>Chất liệu: VẢI JEANS CHẤT LIỆU CAO CẤP', 'Nữ', 250000, 100000, 'quan-jeans-nu-wash-ong-doc-dao.jpg', 'quan-jean-nu-wash-ong-doc-dao', 8, 1, 100, 1),
	(40, 'QUẦN JOGGER DÂY KÉO NỮ XANH BIỂN', 'Phối quần jogger nữ với Áo crop top là item thời trang không thể thiếu trong tủ đồ hè của bạn gái. Chiếc áo cá tính này cũng là “người bạn thân” với quần jogger nữ. Cách phối đồ với quần jogger nữ và áo crop top không chỉ mang đến vẻ đẹp khoẻ khoắn, trẻ trung mà còn giúp các nàng khoe khéo vòng eo “con kiến” của mình.', 'Nữ', 140000, 100000, 'quan-jogger-day-keo-nu-xanh-than.jpg', 'quan-jogger-day-keo-nu-xanh-bien', 9, 1, 100, 1),
	(41, 'QUẦN JOGGER KAKI NỮ XÁM TRẮNG', 'Phối quần jogger nữ với Áo crop top là item thời trang không thể thiếu trong tủ đồ hè của bạn gái. Chiếc áo cá tính này cũng là “người bạn thân” với quần jogger nữ. Cách phối đồ với quần jogger nữ và áo crop top không chỉ mang đến vẻ đẹp khoẻ khoắn, trẻ trung mà còn giúp các nàng khoe khéo vòng eo “con kiến” của mình.', 'Nữ', 220000, 100000, 'quan-jogger-kaki-nu-xam-trang.jpg', 'quan-jooger-kaki-nu-xam-trang', 9, 1, 100, 1),
	(42, 'QUẦN JOGGER NỮ CÓ KHÓA GỐI KAKI ĐEN', 'Phối quần jogger nữ với Áo crop top là item thời trang không thể thiếu trong tủ đồ hè của bạn gái. Chiếc áo cá tính này cũng là “người bạn thân” với quần jogger nữ. Cách phối đồ với quần jogger nữ và áo crop top không chỉ mang đến vẻ đẹp khoẻ khoắn, trẻ trung mà còn giúp các nàng khoe khéo vòng eo “con kiến” của mình.', 'Nữ', 170000, 100000, 'quan-jogger-nu-co-khoa.jpg', 'quan-jogger-nu-co-khoa-goi-kaki-den', 9, 1, 100, 1);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
