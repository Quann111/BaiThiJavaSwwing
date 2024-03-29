USE [master]
GO
/****** Object:  Database [QuanLyBanSua]    Script Date: 6/2/2022 10:11:08 PM ******/
CREATE DATABASE [QuanLyBanSua]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'QuanLyBanSua', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\QuanLyBanSua.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'QuanLyBanSua_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\QuanLyBanSua_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [QuanLyBanSua] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [QuanLyBanSua].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [QuanLyBanSua] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [QuanLyBanSua] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [QuanLyBanSua] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [QuanLyBanSua] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [QuanLyBanSua] SET ARITHABORT OFF 
GO
ALTER DATABASE [QuanLyBanSua] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [QuanLyBanSua] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [QuanLyBanSua] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [QuanLyBanSua] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [QuanLyBanSua] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [QuanLyBanSua] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [QuanLyBanSua] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [QuanLyBanSua] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [QuanLyBanSua] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [QuanLyBanSua] SET  DISABLE_BROKER 
GO
ALTER DATABASE [QuanLyBanSua] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [QuanLyBanSua] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [QuanLyBanSua] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [QuanLyBanSua] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [QuanLyBanSua] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [QuanLyBanSua] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [QuanLyBanSua] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [QuanLyBanSua] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [QuanLyBanSua] SET  MULTI_USER 
GO
ALTER DATABASE [QuanLyBanSua] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [QuanLyBanSua] SET DB_CHAINING OFF 
GO
ALTER DATABASE [QuanLyBanSua] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [QuanLyBanSua] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [QuanLyBanSua] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [QuanLyBanSua] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [QuanLyBanSua] SET QUERY_STORE = OFF
GO
USE [QuanLyBanSua]
GO
/****** Object:  User [vucute]    Script Date: 6/2/2022 10:11:08 PM ******/
CREATE USER [vucute] WITHOUT LOGIN WITH DEFAULT_SCHEMA=[dbo]
GO
/****** Object:  Table [dbo].[ChiTietHoaDon]    Script Date: 6/2/2022 10:11:08 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietHoaDon](
	[MaHD] [varchar](10) NOT NULL,
	[MaSP] [varchar](10) NOT NULL,
	[SoLuong] [int] NOT NULL,
	[DonGia] [float] NOT NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ChiTietPhieuNhap]    Script Date: 6/2/2022 10:11:08 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietPhieuNhap](
	[MaPN] [varchar](10) NOT NULL,
	[MaSP] [varchar](10) NOT NULL,
	[SoLuong] [int] NOT NULL,
	[DonGia] [float] NOT NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDon]    Script Date: 6/2/2022 10:11:08 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDon](
	[MaHD] [varchar](10) NOT NULL,
	[MaNV] [varchar](10) NOT NULL,
	[MaKH] [varchar](10) NOT NULL,
	[NgayLap] [date] NOT NULL,
	[TongTien] [float] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MaHD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 6/2/2022 10:11:08 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhachHang](
	[MaKH] [varchar](10) NOT NULL,
	[TenKH] [nvarchar](50) NOT NULL,
	[DiaChi] [nvarchar](20) NOT NULL,
	[SDT] [varchar](12) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MaKH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NguoiDung]    Script Date: 6/2/2022 10:11:08 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NguoiDung](
	[TaiKhoan] [varchar](10) NOT NULL,
	[MatKhau] [varchar](10) NOT NULL,
	[MaNV] [varchar](10) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[TaiKhoan] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhaCungCap]    Script Date: 6/2/2022 10:11:08 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhaCungCap](
	[MaNCC] [varchar](10) NOT NULL,
	[TenNCC] [nvarchar](20) NOT NULL,
	[DiaChi] [nvarchar](20) NOT NULL,
	[SDT] [varchar](12) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MaNCC] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 6/2/2022 10:11:08 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVien](
	[MaNV] [varchar](10) NOT NULL,
	[TenNV] [nvarchar](50) NOT NULL,
	[NgaySinh] [date] NOT NULL,
	[DiaChi] [nvarchar](50) NOT NULL,
	[SDT] [varchar](12) NOT NULL,
	[PhanQuyen] [varchar](10) NULL,
 CONSTRAINT [PK__NhanVien__2725D70A630506DA] PRIMARY KEY CLUSTERED 
(
	[MaNV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PhieuNhap]    Script Date: 6/2/2022 10:11:08 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhieuNhap](
	[MaPN] [varchar](10) NOT NULL,
	[MaNCC] [varchar](10) NOT NULL,
	[MaNV] [varchar](10) NOT NULL,
	[NgayLap] [date] NOT NULL,
	[TongTien] [float] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MaPN] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SanPham]    Script Date: 6/2/2022 10:11:08 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SanPham](
	[MaSP] [varchar](10) NOT NULL,
	[TenSP] [nvarchar](50) NULL,
	[Loai] [nvarchar](30) NULL,
	[HangSD] [date] NULL,
	[DonGia] [float] NULL,
	[SoLuong] [int] NULL,
	[HinhAnh] [varchar](200) NULL,
 CONSTRAINT [PK__SanPham__2725081C3D797E7A] PRIMARY KEY CLUSTERED 
(
	[MaSP] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[ChiTietHoaDon] ([MaHD], [MaSP], [SoLuong], [DonGia]) VALUES (N'HD2', N'SP6', 10, 20)
INSERT [dbo].[ChiTietHoaDon] ([MaHD], [MaSP], [SoLuong], [DonGia]) VALUES (N'HD2', N'SP1', 2, 20)
INSERT [dbo].[ChiTietHoaDon] ([MaHD], [MaSP], [SoLuong], [DonGia]) VALUES (N'HD1', N'SP1', 1, 20)
INSERT [dbo].[ChiTietHoaDon] ([MaHD], [MaSP], [SoLuong], [DonGia]) VALUES (N'HD3', N'SP4', 1, 15)
INSERT [dbo].[ChiTietHoaDon] ([MaHD], [MaSP], [SoLuong], [DonGia]) VALUES (N'HD3', N'SP6', 1, 20)
INSERT [dbo].[ChiTietHoaDon] ([MaHD], [MaSP], [SoLuong], [DonGia]) VALUES (N'HD1', N'SP2', 10, 8.2)
INSERT [dbo].[ChiTietHoaDon] ([MaHD], [MaSP], [SoLuong], [DonGia]) VALUES (N'HD1', N'SP3', 11, 15)
INSERT [dbo].[ChiTietHoaDon] ([MaHD], [MaSP], [SoLuong], [DonGia]) VALUES (N'HD4', N'SP1', 3, 20)
INSERT [dbo].[ChiTietHoaDon] ([MaHD], [MaSP], [SoLuong], [DonGia]) VALUES (N'HD5', N'SP2', 1, 19.9)
INSERT [dbo].[ChiTietHoaDon] ([MaHD], [MaSP], [SoLuong], [DonGia]) VALUES (N'HD5', N'SP4', 3, 3.9)
INSERT [dbo].[ChiTietHoaDon] ([MaHD], [MaSP], [SoLuong], [DonGia]) VALUES (N'HD6', N'SP4', 1, 3.9)
INSERT [dbo].[ChiTietHoaDon] ([MaHD], [MaSP], [SoLuong], [DonGia]) VALUES (N'HD6', N'SP3', 1, 7.9)
INSERT [dbo].[ChiTietHoaDon] ([MaHD], [MaSP], [SoLuong], [DonGia]) VALUES (N'HD6', N'SP8', 5, 23)
INSERT [dbo].[ChiTietHoaDon] ([MaHD], [MaSP], [SoLuong], [DonGia]) VALUES (N'HD6', N'SP10', 2, 23.9)
INSERT [dbo].[ChiTietHoaDon] ([MaHD], [MaSP], [SoLuong], [DonGia]) VALUES (N'HD7', N'SP10', 1, 23.9)
INSERT [dbo].[ChiTietHoaDon] ([MaHD], [MaSP], [SoLuong], [DonGia]) VALUES (N'HD7', N'SP12', 2, 7.9)
INSERT [dbo].[ChiTietHoaDon] ([MaHD], [MaSP], [SoLuong], [DonGia]) VALUES (N'HD7', N'SP1', 3, 11.9)
INSERT [dbo].[ChiTietHoaDon] ([MaHD], [MaSP], [SoLuong], [DonGia]) VALUES (N'HD7', N'SP1', 1, 5.6)
INSERT [dbo].[ChiTietHoaDon] ([MaHD], [MaSP], [SoLuong], [DonGia]) VALUES (N'HD8', N'SP15', 1, 5.5)
INSERT [dbo].[ChiTietHoaDon] ([MaHD], [MaSP], [SoLuong], [DonGia]) VALUES (N'HD8', N'SP1', 1, 11.9)
INSERT [dbo].[ChiTietHoaDon] ([MaHD], [MaSP], [SoLuong], [DonGia]) VALUES (N'HD9', N'SP10', 1, 23.9)
INSERT [dbo].[ChiTietHoaDon] ([MaHD], [MaSP], [SoLuong], [DonGia]) VALUES (N'HD9', N'SP1', 1, 20)
INSERT [dbo].[ChiTietHoaDon] ([MaHD], [MaSP], [SoLuong], [DonGia]) VALUES (N'HD10', N'SP13', 1, 7.9)
INSERT [dbo].[ChiTietHoaDon] ([MaHD], [MaSP], [SoLuong], [DonGia]) VALUES (N'HD10', N'SP5', 10, 25.7)
INSERT [dbo].[ChiTietHoaDon] ([MaHD], [MaSP], [SoLuong], [DonGia]) VALUES (N'HD10', N'SP6', 10, 6.5)
GO
INSERT [dbo].[ChiTietPhieuNhap] ([MaPN], [MaSP], [SoLuong], [DonGia]) VALUES (N'PN1', N'SP8', 2, 23)
INSERT [dbo].[ChiTietPhieuNhap] ([MaPN], [MaSP], [SoLuong], [DonGia]) VALUES (N'PN2', N'SP3', 35, 7.9)
INSERT [dbo].[ChiTietPhieuNhap] ([MaPN], [MaSP], [SoLuong], [DonGia]) VALUES (N'PN3', N'SP1', 5, 20)
INSERT [dbo].[ChiTietPhieuNhap] ([MaPN], [MaSP], [SoLuong], [DonGia]) VALUES (N'PN4', N'SP14', 1, 5.5)
INSERT [dbo].[ChiTietPhieuNhap] ([MaPN], [MaSP], [SoLuong], [DonGia]) VALUES (N'PN4', N'SP12', 1, 7.9)
INSERT [dbo].[ChiTietPhieuNhap] ([MaPN], [MaSP], [SoLuong], [DonGia]) VALUES (N'PN4', N'SP1', 1, 20)
INSERT [dbo].[ChiTietPhieuNhap] ([MaPN], [MaSP], [SoLuong], [DonGia]) VALUES (N'PN4', N'SP7', 1, 15.4)
INSERT [dbo].[ChiTietPhieuNhap] ([MaPN], [MaSP], [SoLuong], [DonGia]) VALUES (N'PN5', N'SP15', 1, 5.5)
INSERT [dbo].[ChiTietPhieuNhap] ([MaPN], [MaSP], [SoLuong], [DonGia]) VALUES (N'PN5', N'SP14', 1, 5.5)
INSERT [dbo].[ChiTietPhieuNhap] ([MaPN], [MaSP], [SoLuong], [DonGia]) VALUES (N'PN5', N'SP11', 1, 15.9)
INSERT [dbo].[ChiTietPhieuNhap] ([MaPN], [MaSP], [SoLuong], [DonGia]) VALUES (N'PN5', N'SP1', 1, 20)
INSERT [dbo].[ChiTietPhieuNhap] ([MaPN], [MaSP], [SoLuong], [DonGia]) VALUES (N'PN6', N'SP10', 1, 23.9)
INSERT [dbo].[ChiTietPhieuNhap] ([MaPN], [MaSP], [SoLuong], [DonGia]) VALUES (N'PN6', N'SP15', 10, 5.5)
INSERT [dbo].[ChiTietPhieuNhap] ([MaPN], [MaSP], [SoLuong], [DonGia]) VALUES (N'PN6', N'SP17', 5, 5.6)
INSERT [dbo].[ChiTietPhieuNhap] ([MaPN], [MaSP], [SoLuong], [DonGia]) VALUES (N'PN7', N'SP3', 100, 8)
INSERT [dbo].[ChiTietPhieuNhap] ([MaPN], [MaSP], [SoLuong], [DonGia]) VALUES (N'PN7', N'SP2', 10, 39)
INSERT [dbo].[ChiTietPhieuNhap] ([MaPN], [MaSP], [SoLuong], [DonGia]) VALUES (N'PN8', N'SP1', 10, 11.9)
INSERT [dbo].[ChiTietPhieuNhap] ([MaPN], [MaSP], [SoLuong], [DonGia]) VALUES (N'PN9', N'SP1', 10, 20)
GO
INSERT [dbo].[HoaDon] ([MaHD], [MaNV], [MaKH], [NgayLap], [TongTien]) VALUES (N'HD1', N'NV2', N'KH2', CAST(N'2021-04-18' AS Date), 267)
INSERT [dbo].[HoaDon] ([MaHD], [MaNV], [MaKH], [NgayLap], [TongTien]) VALUES (N'HD10', N'NV10', N'KH2', CAST(N'2022-02-24' AS Date), 329.9)
INSERT [dbo].[HoaDon] ([MaHD], [MaNV], [MaKH], [NgayLap], [TongTien]) VALUES (N'HD2', N'NV1', N'KH10', CAST(N'2021-04-18' AS Date), 240)
INSERT [dbo].[HoaDon] ([MaHD], [MaNV], [MaKH], [NgayLap], [TongTien]) VALUES (N'HD3', N'NV1', N'KH1', CAST(N'2022-04-19' AS Date), 35)
INSERT [dbo].[HoaDon] ([MaHD], [MaNV], [MaKH], [NgayLap], [TongTien]) VALUES (N'HD4', N'NV1', N'KH9', CAST(N'2021-04-21' AS Date), 60)
INSERT [dbo].[HoaDon] ([MaHD], [MaNV], [MaKH], [NgayLap], [TongTien]) VALUES (N'HD5', N'NV15', N'KH8', CAST(N'2022-03-24' AS Date), 31.6)
INSERT [dbo].[HoaDon] ([MaHD], [MaNV], [MaKH], [NgayLap], [TongTien]) VALUES (N'HD6', N'NV15', N'KH7', CAST(N'2021-04-24' AS Date), 174.6)
INSERT [dbo].[HoaDon] ([MaHD], [MaNV], [MaKH], [NgayLap], [TongTien]) VALUES (N'HD7', N'NV12', N'KH3', CAST(N'2022-01-24' AS Date), 81)
INSERT [dbo].[HoaDon] ([MaHD], [MaNV], [MaKH], [NgayLap], [TongTien]) VALUES (N'HD8', N'NV13', N'KH3', CAST(N'2021-04-24' AS Date), 17.4)
INSERT [dbo].[HoaDon] ([MaHD], [MaNV], [MaKH], [NgayLap], [TongTien]) VALUES (N'HD9', N'NV15', N'KH7', CAST(N'2022-02-24' AS Date), 43.9)
GO
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [DiaChi], [SDT]) VALUES (N'KH1', N'Phan Thanh Son', N'Thái Bình', N'0145647854')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [DiaChi], [SDT]) VALUES (N'KH10', N'Lê Duy Sóng', N'Thái Bình', N'01261111193')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [DiaChi], [SDT]) VALUES (N'KH2', N'Nguyễn Thi Hoa', N'Long An', N'01262368193')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [DiaChi], [SDT]) VALUES (N'KH3', N'Phan  Trinh', N'Long An', N'0363333168')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [DiaChi], [SDT]) VALUES (N'KH4', N'Lê Công Huynh', N'Sóc Trang', N'0977232173')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [DiaChi], [SDT]) VALUES (N'KH5', N'Lê Duy Hoa', N'TP HCM', N'0805222235')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [DiaChi], [SDT]) VALUES (N'KH6', N'Duong Thanh Hùng', N'Vung Tàu', N'0971111118')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [DiaChi], [SDT]) VALUES (N'KH7', N'Duong Van Công', N'Thái Bình', N'0394545431')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [DiaChi], [SDT]) VALUES (N'KH8', N'Hoàng Thanh Hùng', N'Long An', N'0276886265')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [DiaChi], [SDT]) VALUES (N'KH9', N'Nguyễn Hoàng Âu', N'Hu?', N'0363333326')
GO
INSERT [dbo].[NguoiDung] ([TaiKhoan], [MatKhau], [MaNV]) VALUES (N'abc', N'287', N'NV1')
INSERT [dbo].[NguoiDung] ([TaiKhoan], [MatKhau], [MaNV]) VALUES (N'admin', N'admin', N'NV12')
INSERT [dbo].[NguoiDung] ([TaiKhoan], [MatKhau], [MaNV]) VALUES (N'Quan Ly', N'quanly', N'NV9')
INSERT [dbo].[NguoiDung] ([TaiKhoan], [MatKhau], [MaNV]) VALUES (N'ThanhTuNH', N'thanhtu', N'NV5')
INSERT [dbo].[NguoiDung] ([TaiKhoan], [MatKhau], [MaNV]) VALUES (N'VanHoang', N'vanhoang', N'NV4')
INSERT [dbo].[NguoiDung] ([TaiKhoan], [MatKhau], [MaNV]) VALUES (N'VanTaiNH', N'vantai', N'NV12')
INSERT [dbo].[NguoiDung] ([TaiKhoan], [MatKhau], [MaNV]) VALUES (N'vu', N'xxx', N'NV2')
GO
INSERT [dbo].[NhaCungCap] ([MaNCC], [TenNCC], [DiaChi], [SDT]) VALUES (N'NCC1', N'Nestle', N'Thái Bình', N'01200000193')
INSERT [dbo].[NhaCungCap] ([MaNCC], [TenNCC], [DiaChi], [SDT]) VALUES (N'NCC2', N'Nutifood', N'Thái Bình', N'01261999999')
INSERT [dbo].[NhaCungCap] ([MaNCC], [TenNCC], [DiaChi], [SDT]) VALUES (N'NCC3', N'Cô gái Hà Lan', N'Long An', N'01269999993')
INSERT [dbo].[NhaCungCap] ([MaNCC], [TenNCC], [DiaChi], [SDT]) VALUES (N'NCC4', N'Vinamilk', N'Long An', N'0555555168')
INSERT [dbo].[NhaCungCap] ([MaNCC], [TenNCC], [DiaChi], [SDT]) VALUES (N'NCC5', N'TrueMilk', N'Thái Bình', N'01221111193')
INSERT [dbo].[NhaCungCap] ([MaNCC], [TenNCC], [DiaChi], [SDT]) VALUES (N'NCC6', N'Fami', N'Long An', N'01343434193')
INSERT [dbo].[NhaCungCap] ([MaNCC], [TenNCC], [DiaChi], [SDT]) VALUES (N'NCC7', N'VPMilk', N'Nhat Ban', N'0322223168')
GO
INSERT [dbo].[NhanVien] ([MaNV], [TenNV], [NgaySinh], [DiaChi], [SDT], [PhanQuyen]) VALUES (N'NV1', N'Tran Le Anh Vu', CAST(N'2002-07-28' AS Date), N'Thái Bình', N'0145647854', N'1')
INSERT [dbo].[NhanVien] ([MaNV], [TenNV], [NgaySinh], [DiaChi], [SDT], [PhanQuyen]) VALUES (N'NV10', N'Nguyễn Thị Hồng Hạnh', CAST(N'2002-11-29' AS Date), N'Bến Tre', N'01262368193', N'1')
INSERT [dbo].[NhanVien] ([MaNV], [TenNV], [NgaySinh], [DiaChi], [SDT], [PhanQuyen]) VALUES (N'NV11', N'Phan Thị Hồng Trinh', CAST(N'2002-12-11' AS Date), N'Nghệ An', N'0366227168', N'1')
INSERT [dbo].[NhanVien] ([MaNV], [TenNV], [NgaySinh], [DiaChi], [SDT], [PhanQuyen]) VALUES (N'NV12', N'Phan Văn Tài', CAST(N'2002-06-15' AS Date), N'Kiên Giang', N'0981578293', N'0')
INSERT [dbo].[NhanVien] ([MaNV], [TenNV], [NgaySinh], [DiaChi], [SDT], [PhanQuyen]) VALUES (N'NV13', N'Lê Công Huynh', CAST(N'2002-09-12' AS Date), N'Sóc Trăng', N'0977232173', N'1')
INSERT [dbo].[NhanVien] ([MaNV], [TenNV], [NgaySinh], [DiaChi], [SDT], [PhanQuyen]) VALUES (N'NV14', N'Lê Hồng Hoa', CAST(N'2002-08-13' AS Date), N'TP HCM', N'0805126735', N'1')
INSERT [dbo].[NhanVien] ([MaNV], [TenNV], [NgaySinh], [DiaChi], [SDT], [PhanQuyen]) VALUES (N'NV15', N'Nguyễn Thị My', CAST(N'2002-12-30' AS Date), N'Hà Nội', N'0703689147', N'1')
INSERT [dbo].[NhanVien] ([MaNV], [TenNV], [NgaySinh], [DiaChi], [SDT], [PhanQuyen]) VALUES (N'NV2', N'Nguyen Van N', CAST(N'2002-11-11' AS Date), N'Thái Bình', N'01263368193', N'0')
INSERT [dbo].[NhanVien] ([MaNV], [TenNV], [NgaySinh], [DiaChi], [SDT], [PhanQuyen]) VALUES (N'NV3', N'Nguyễn Bá Được', CAST(N'2002-04-05' AS Date), N'Hà Nội', N'0128456786', N'1')
INSERT [dbo].[NhanVien] ([MaNV], [TenNV], [NgaySinh], [DiaChi], [SDT], [PhanQuyen]) VALUES (N'NV4', N'Trần Văn Hoàng', CAST(N'2002-11-12' AS Date), N'TP HCM', N'01207764668', N'1')
INSERT [dbo].[NhanVien] ([MaNV], [TenNV], [NgaySinh], [DiaChi], [SDT], [PhanQuyen]) VALUES (N'NV5', N'Lê Thanh Tú', CAST(N'2002-04-11' AS Date), N'Hải Phòng', N'0367756753', N'1')
INSERT [dbo].[NhanVien] ([MaNV], [TenNV], [NgaySinh], [DiaChi], [SDT], [PhanQuyen]) VALUES (N'NV6', N'Nguyễn Hải Âu', CAST(N'2002-04-24' AS Date), N'Huế', N'0364198226', N'1')
INSERT [dbo].[NhanVien] ([MaNV], [TenNV], [NgaySinh], [DiaChi], [SDT], [PhanQuyen]) VALUES (N'NV7', N'Hoàng Thanh Hùng', CAST(N'2002-11-13' AS Date), N'Long An', N'0276886265', N'1')
INSERT [dbo].[NhanVien] ([MaNV], [TenNV], [NgaySinh], [DiaChi], [SDT], [PhanQuyen]) VALUES (N'NV8', N'Trịnh Văn Công', CAST(N'2002-07-16' AS Date), N'Tiền Giang', N'0392656931', N'1')
INSERT [dbo].[NhanVien] ([MaNV], [TenNV], [NgaySinh], [DiaChi], [SDT], [PhanQuyen]) VALUES (N'NV9', N'Dương Thanh Hồng', CAST(N'2002-12-03' AS Date), N'Vũng Tàu', N'0977268398', N'1')
GO
INSERT [dbo].[PhieuNhap] ([MaPN], [MaNCC], [MaNV], [NgayLap], [TongTien]) VALUES (N'PN1', N'NCC2', N'NV1', CAST(N'2021-03-24' AS Date), 296)
INSERT [dbo].[PhieuNhap] ([MaPN], [MaNCC], [MaNV], [NgayLap], [TongTien]) VALUES (N'PN2', N'NCC3', N'NV1', CAST(N'2022-03-24' AS Date), 276.5)
INSERT [dbo].[PhieuNhap] ([MaPN], [MaNCC], [MaNV], [NgayLap], [TongTien]) VALUES (N'PN3', N'NCC5', N'NV12', CAST(N'2022-02-25' AS Date), 100)
INSERT [dbo].[PhieuNhap] ([MaPN], [MaNCC], [MaNV], [NgayLap], [TongTien]) VALUES (N'PN4', N'NCC4', N'NV12', CAST(N'2022-01-26' AS Date), 48.8)
INSERT [dbo].[PhieuNhap] ([MaPN], [MaNCC], [MaNV], [NgayLap], [TongTien]) VALUES (N'PN5', N'NCC5', N'NV12', CAST(N'2022-02-26' AS Date), 46.9)
INSERT [dbo].[PhieuNhap] ([MaPN], [MaNCC], [MaNV], [NgayLap], [TongTien]) VALUES (N'PN6', N'NCC7', N'NV12', CAST(N'2022-03-26' AS Date), 106.9)
INSERT [dbo].[PhieuNhap] ([MaPN], [MaNCC], [MaNV], [NgayLap], [TongTien]) VALUES (N'PN7', N'NCC6', N'NV12', CAST(N'2021-02-01' AS Date), 1190)
INSERT [dbo].[PhieuNhap] ([MaPN], [MaNCC], [MaNV], [NgayLap], [TongTien]) VALUES (N'PN8', N'NCC1', N'NV12', CAST(N'2021-01-10' AS Date), 119)
INSERT [dbo].[PhieuNhap] ([MaPN], [MaNCC], [MaNV], [NgayLap], [TongTien]) VALUES (N'PN9', N'NCC2', N'NV12', CAST(N'2021-05-10' AS Date), 200)
GO
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [Loai], [HangSD], [DonGia], [SoLuong], [HinhAnh]) VALUES (N'SP1', N'Sua Kem Dutch Lady', N'Lon', CAST(N'2022-11-15' AS Date), 120, 17, N'cghllon.png')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [Loai], [HangSD], [DonGia], [SoLuong], [HinhAnh]) VALUES (N'SP10', N'Sua Nuti Bich', N'Bich', CAST(N'2022-07-08' AS Date), 10, 40, N'nutibich.png')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [Loai], [HangSD], [DonGia], [SoLuong], [HinhAnh]) VALUES (N'SP11', N'Sua Nuti Hop', N'Hop', CAST(N'2022-12-15' AS Date), 12, 77, N'nutihop.png')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [Loai], [HangSD], [DonGia], [SoLuong], [HinhAnh]) VALUES (N'SP12', N'Sua TrueMilk', N'Hop', CAST(N'2022-11-15' AS Date), 10, 30, N'truemilkhop.png')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [Loai], [HangSD], [DonGia], [SoLuong], [HinhAnh]) VALUES (N'SP13', N'Sua TrueMilk Lon', N'Lon', CAST(N'2022-09-15' AS Date), 90, 56, N'truemilklon.png')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [Loai], [HangSD], [DonGia], [SoLuong], [HinhAnh]) VALUES (N'SP14', N'Sua TrueMilk Bich', N'Bich', CAST(N'2022-12-15' AS Date), 10, 36, N'truemilkbich.png')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [Loai], [HangSD], [DonGia], [SoLuong], [HinhAnh]) VALUES (N'SP15', N'Sua Chua TrueMilk', N'Chai', CAST(N'2022-06-15' AS Date), 20, 90, N'truemilk_chai.png')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [Loai], [HangSD], [DonGia], [SoLuong], [HinhAnh]) VALUES (N'SP16', N'Sua ViTaMilk Co Duong a d3', N'Bich', CAST(N'2022-07-19' AS Date), 21, 170, N'null')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [Loai], [HangSD], [DonGia], [SoLuong], [HinhAnh]) VALUES (N'SP17', N'Sua ViTaMilk Khong Duong ', N'Bich', CAST(N'2022-10-20' AS Date), 15, 120, N'vinamilkkoduong.png')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [Loai], [HangSD], [DonGia], [SoLuong], [HinhAnh]) VALUES (N'SP18', N'Sua ViTaMilk SoCola ', N'Bich', CAST(N'2022-07-15' AS Date), 15, 120, N'vitamilkbich.png')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [Loai], [HangSD], [DonGia], [SoLuong], [HinhAnh]) VALUES (N'SP19', N'Sua VPMilk', N'Bich', CAST(N'2022-11-19' AS Date), 10, 70, N'vpbich.png')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [Loai], [HangSD], [DonGia], [SoLuong], [HinhAnh]) VALUES (N'SP2', N'Sua Tuoi Tiet Trung Dutch Lady', N'Hop', CAST(N'2022-01-13' AS Date), 15, 90, N'cghlhop.png')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [Loai], [HangSD], [DonGia], [SoLuong], [HinhAnh]) VALUES (N'SP20', N'Sua VPMilk', N'Hop', CAST(N'2022-09-15' AS Date), 12, 64, N'vphop.png')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [Loai], [HangSD], [DonGia], [SoLuong], [HinhAnh]) VALUES (N'SP21', N'Sua Vitamilk Hop lon', N'Hop', CAST(N'2022-07-07' AS Date), 150, 50, N'vitamilkhoplon.png')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [Loai], [HangSD], [DonGia], [SoLuong], [HinhAnh]) VALUES (N'SP22', N'Sua Vitamillkk', N'Hop', CAST(N'2022-06-06' AS Date), 10, 45, N'vitamilkhopnho.png')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [Loai], [HangSD], [DonGia], [SoLuong], [HinhAnh]) VALUES (N'SP3', N'Sua FAMI Canxi', N'Hop', CAST(N'2022-08-15' AS Date), 10, 50, N'sau_fami_hop1.png')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [Loai], [HangSD], [DonGia], [SoLuong], [HinhAnh]) VALUES (N'SP4', N'Sua FAMI Nguyen Chat', N'Hop', CAST(N'2022-06-30' AS Date), 10, 50, N'sua_fami_hop.jpg')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [Loai], [HangSD], [DonGia], [SoLuong], [HinhAnh]) VALUES (N'SP5', N'Sua FAMI Canxi', N'Bich', CAST(N'2022-12-31' AS Date), 15, 60, N'sua_fami_bich.jpg')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [Loai], [HangSD], [DonGia], [SoLuong], [HinhAnh]) VALUES (N'SP6', N'Sua Milo Hop', N'Hop', CAST(N'2022-10-07' AS Date), 10, 70, N'suamilohop.png')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [Loai], [HangSD], [DonGia], [SoLuong], [HinhAnh]) VALUES (N'SP7', N'Sua Milo Goi', N'Goi', CAST(N'2022-08-27' AS Date), 7, 100, N'suamiloBich.png')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [Loai], [HangSD], [DonGia], [SoLuong], [HinhAnh]) VALUES (N'SP8', N'Sua Milo Lon', N'Lon', CAST(N'2022-12-26' AS Date), 125, 50, N'suamiloLon.png')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [Loai], [HangSD], [DonGia], [SoLuong], [HinhAnh]) VALUES (N'SP9', N'Sua Nuti Lon', N'Lon', CAST(N'2022-10-27' AS Date), 120, 30, N'nutiLon.png')
GO
ALTER TABLE [dbo].[ChiTietHoaDon]  WITH CHECK ADD FOREIGN KEY([MaHD])
REFERENCES [dbo].[HoaDon] ([MaHD])
GO
ALTER TABLE [dbo].[ChiTietHoaDon]  WITH CHECK ADD  CONSTRAINT [FK__ChiTietHoa__MaSP__38996AB5] FOREIGN KEY([MaSP])
REFERENCES [dbo].[SanPham] ([MaSP])
GO
ALTER TABLE [dbo].[ChiTietHoaDon] CHECK CONSTRAINT [FK__ChiTietHoa__MaSP__38996AB5]
GO
ALTER TABLE [dbo].[ChiTietPhieuNhap]  WITH CHECK ADD FOREIGN KEY([MaPN])
REFERENCES [dbo].[PhieuNhap] ([MaPN])
GO
ALTER TABLE [dbo].[ChiTietPhieuNhap]  WITH CHECK ADD  CONSTRAINT [FK__ChiTietPhi__MaSP__31EC6D26] FOREIGN KEY([MaSP])
REFERENCES [dbo].[SanPham] ([MaSP])
GO
ALTER TABLE [dbo].[ChiTietPhieuNhap] CHECK CONSTRAINT [FK__ChiTietPhi__MaSP__31EC6D26]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD FOREIGN KEY([MaKH])
REFERENCES [dbo].[KhachHang] ([MaKH])
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK__HoaDon__MaNV__34C8D9D1] FOREIGN KEY([MaNV])
REFERENCES [dbo].[NhanVien] ([MaNV])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK__HoaDon__MaNV__34C8D9D1]
GO
ALTER TABLE [dbo].[NguoiDung]  WITH CHECK ADD  CONSTRAINT [FK__NguoiDung__MaNV__3B75D760] FOREIGN KEY([MaNV])
REFERENCES [dbo].[NhanVien] ([MaNV])
GO
ALTER TABLE [dbo].[NguoiDung] CHECK CONSTRAINT [FK__NguoiDung__MaNV__3B75D760]
GO
ALTER TABLE [dbo].[PhieuNhap]  WITH CHECK ADD FOREIGN KEY([MaNCC])
REFERENCES [dbo].[NhaCungCap] ([MaNCC])
GO
ALTER TABLE [dbo].[PhieuNhap]  WITH CHECK ADD  CONSTRAINT [FK__PhieuNhap__MaNV__2D27B809] FOREIGN KEY([MaNV])
REFERENCES [dbo].[NhanVien] ([MaNV])
GO
ALTER TABLE [dbo].[PhieuNhap] CHECK CONSTRAINT [FK__PhieuNhap__MaNV__2D27B809]
GO
USE [master]
GO
ALTER DATABASE [QuanLyBanSua] SET  READ_WRITE 
GO
