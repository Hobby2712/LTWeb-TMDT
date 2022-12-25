use master
Create database NKDShop
GO
USE NKDShop
GO
SET Dateformat dmy
Go

CREATE TABLE category1(
	cId int IDENTITY(1,1) PRIMARY KEY not null,
	cName nvarchar(50) NULL,
	cImage nvarchar(max),
	createAt date DEFAULT(getdate()),
)
go
Insert into category1 values (N'Áo','/uploads/category/ao.png','27-9-2022')
Insert into category1 values (N'Quần','/uploads/category/quan.png','27-9-2022')
Insert into category1 values (N'Mũ','/uploads/category/mu.png','27-9-2022')
Insert into category1 values (N'Ba lô','/uploads/category/balo.png','27-9-2022')
Insert into category1 values (N'Phụ kiện','/uploads/category/phukien.png','27-9-2022')
Go

CREATE TABLE category2(
	cId int IDENTITY(1,1) PRIMARY KEY not null,
	cName nvarchar(50) NULL,
	cImage nvarchar(max),
	createAt date DEFAULT(getdate()),
	cIdBig int references category1(cId),
)
go
Insert into category2 values (N'Áo Khoác','/uploads/category/ao/aokhoac.png','27-9-2022',1)
Insert into category2 values (N'Áo Hoodie','/uploads/category/ao/aohoodie.png','27-9-2022',1)
Insert into category2 values (N'Áo Polo','/uploads/category/ao/aopolo.png','27-9-2022',1)
Insert into category2 values (N'Áo Thun','/uploads/category/ao/aothun.png','27-9-2022',1)
Insert into category2 values (N'Áo Sơ mi','/uploads/category/ao/aosomi.png','27-9-2022',1)
Insert into category2 values (N'Quần Short','/uploads/category/quan/quanshort.png','27-9-2022',2)
Insert into category2 values (N'Quần Tây','/uploads/category/quan/quantay.png','27-9-2022',2)
Insert into category2 values (N'Quần Jogger','/uploads/category/quan/quanjogger.png','27-9-2022',2)
Insert into category2 values (N'Quần Jeans','/uploads/category/quan/quanjeans.png','27-9-2022',2)
Insert into category2 values (N'Mũ Len','/uploads/category/mu/mulen.png','27-9-2022',3)
Insert into category2 values (N'Mũ Lưỡi Trai','/uploads/category/mu/muluoitrai.png','27-9-2022',3)
Insert into category2 values (N'Mũ Fedora','/uploads/category/mu/mufedora.png','27-9-2022',3)
Insert into category2 values (N'Ba lô','/uploads/category/balo/balo.png','27-9-2022',4)
Insert into category2 values (N'Túi','/uploads/category/balo/tui.png','27-9-2022',4)
Insert into category2 values (N'Thắt lưng','/uploads/category/phukien/thatlung.png','27-9-2022',5)
Insert into category2 values (N'Ví','/uploads/category/phukien/vi.png','27-9-2022',5)
Insert into category2 values (N'Cà vạt','/uploads/category/phukien/cavat.png','27-9-2022',5)
Insert into category2 values (N'Mắt kính','/uploads/category/phukien/matkinh.png','27-9-2022',5)


GO
create table dbo.[role](
	idRole int IDENTITY PRIMARY KEY not null,
	nameRole nvarchar(50)
)
go
Insert into dbo.[role] values ('admin')
Insert into dbo.[role] values ('user')
Insert into dbo.[role] values ('shipper')
Insert into dbo.[role] values ('vendor')

GO
create table [user](
	uId int IDENTITY PRIMARY KEY not null,
	uName varchar(50) ,
	uFullName nvarchar(50),
	uEmail varchar(50),
	uAddress nvarchar(150),
	uPassword varchar(50),
	uPhone char(11),
	idRole int references role(idRole),
	uImage nvarchar(max),
	createAt date DEFAULT(getdate())
)
go
Insert into [user] values ('duong',N'Nguyễn Khắc Dương','ngkhacduong@gmail.com',N'Hồ Chí Minh','12345','0982712772',2,'/uploads/user/hinh1.jpg','27-9-2022')
Insert into [user] values ('lam',N'Phan Duy Lâm','ragoreddd@gmail.com',N'Hồ Chí Minh','12345','0914141414',2,'/uploads/user/hinh2.jpg','28-9-2022')
Insert into [user] values ('hung',N'Lê Anh Hùng','herozzz@gmail.com',N'Hồ Chí Minh','12345','0936363636',2,'/uploads/user/hinh3.jpg','29-9-2022')
Insert into [user] values ('admin',null,null,null,'12345',null,1,null,'27-10-2022')
Insert into [user] values ('shipper',null,null,null,'12345',null,3,null,'28-10-2022')
Insert into [user] values ('vendor1',null,null,null,'12345',null,4,null,'27-10-2022')
Insert into [user] values ('vendor2',null,null,null,'12345',null,4,null,'27-10-2022')
Insert into [user] values ('vendor3',null,null,null,'12345',null,4,null,'27-10-2022')

go
create table store(
	[sId] int IDENTITY(1,1) PRIMARY KEY not null,
	sName nvarchar(50) NULL,
	ownerId int references [user](uId),
	createAt date DEFAULT(getdate()),
	isActive int,
)
go
insert into store values('Store1',6,'27-10-2022',1)
insert into store values('Store2',7,'27-10-2022',1)
insert into store values('Store3',8,'27-10-2022',1)

GO
create table dbo.orderStatus(
	id int primary key,
	statusName nvarchar(20)
)
go
Insert into orderStatus values (1,N'Chờ Xác nhận')
Insert into orderStatus values (2,N'Đang lấy hàng')
Insert into orderStatus values (3,N'Đang giao')
Insert into orderStatus values (4,N'Đã giao')
Insert into orderStatus values (5,N'Đã huỷ')
Insert into orderStatus values (6,N'Chờ shipper nhận')
Insert into orderStatus values (7,N'Trả hàng')
Insert into orderStatus values (8,N'Xác nhận đã lấy')


go
CREATE TABLE dbo.product(
	pId int IDENTITY(1,1) PRIMARY KEY not null,
	pName nvarchar(50) NULL,
	pPrice bigint,
	pImage nvarchar(500) NULL,
	pDescription nvarchar(500) NULL,
	pQuantity int NULL,
	cateId int references category2(cId),
	storeId int references store(sId),
	createAt date DEFAULT(getdate()),
	sold int null,
)
GO
Insert into product values (N'Áo Sơ Mi Regular Caro ASM112',345000,'/uploads/product/ao1.png',N'Chất liệu: Kate
'+CHAR(13)+N'Thành phần: 12% modal và 88% superfine
- Ít nhăn và dễ ủi
- Nhanh khô và thoáng mát
HDSD:
- Áo sơ mi màu phơi trong bóng râm để tránh bạc màu phần vai áo
- Áo sơ mi trắng có thể phơi ngoài nắng để áo trắng sáng hơn ( không phơi quá lâu )',100,5,1,'27-9-2022',0)
Insert into product values (N'Áo Sơ Mi Tay Dài Sợi Modal Tối Giản M11',255000,'/uploads/product/ao2.png',N'Chất liệu: Kate
Thành phần: 12% modal và 88% superfine
- Ít nhăn và dễ ủi
- Nhanh khô và thoáng mát
HDSD:
- Áo sơ mi màu phơi trong bóng râm để tránh bạc màu phần vai áo
- Áo sơ mi trắng có thể phơi ngoài nắng để áo trắng sáng hơn ( không phơi quá lâu )',100,5,1,'27-9-2022',0)
Insert into product values (N'Áo Sơ Mi Cổ Lãnh Tụ Đơn Giản Ver28',297000,'/uploads/product/ao3.png',N'Chất liệu: Vải Linen Gân
Thành phần: 49% Rayon 17% Nylon 34% Polyester
- Mềm mại
- Thấm hút
- Thoáng khí
- Thân thiện
- Nhanh khô
- Co giãn nhẹ
+ Kẹp logo Y_ORIGINALS',100,5,1,'27-9-2022',0)
Insert into product values (N'Áo Hoodie Zipper Đơn Giản Ver64 màu đen',557000,'/uploads/product/ao4.png',N'Chất liệu : French Terry
Thành phần :100% cotton
- Thấm hút thoát ẩm
- Mềm mại
- Co giãn đàn hồi
- Thân thiện môi trường
+ Họa tiết in dẻo
+ Reverse Coil Zipper (Những chiếc khoá túi này có bề mặt ngoài dẹp, phẳng trong khi răng khoá thì ở trong)',100,2,1,'27-9-2022',0)
Insert into product values (N'Áo Khoác Lá Cổ Đơn Giản Ver3',457000,'/uploads/product/ao5.png',N'Chất liệu: Vải Dù
Thành phần: 100% Polyester
- Họa tiết in cao
+ Cổ tay áo bo thun gân
+ Túi trong tiện lợi
+ Gấu áo có dây rút
+ Reverse Coil Zipper (Những chiếc khoá túi này có bề mặt ngoài dẹp, phẳng trong khi răng khoá thì ở trong)',100,1,1,'27-9-2022',0)
Insert into product values (N'Áo Hoodie Zipper Đơn Giản Ver64 màu nâu',557000,'/uploads/product/ao6.png',N'Chất liệu: French Terry
Thành phần: 100% Cotton
- Thấm hút thoát ẩm
- Mềm mại
- Co giãn đàn hồi
- Thân thiện môi trường
+ Họa tiết in dẻo
+ Reverse Coil Zipper (Những chiếc khoá túi này có bề mặt ngoài dẹp, phẳng trong khi răng khoá thì ở trong)',100,2,1,'27-9-2022',0)
Insert into product values (N'Áo Thun Cổ Tròn Đơn Giản Ver90',227000,'/uploads/product/ao7.png',N'Chất liệu: Cotton Compact 2C
Thành phần: 100% Cotton
- Thân thiện
- Thấm hút thoát ẩm
- Mềm mại
- Kiểm soát mùi
- Điều hòa nhiệt
+ Họa tiết in dẻo
- HDSD:
+ Nên giặt chung với sản phẩm cùng màu
+ Không dùng thuốc tẩy hoặc xà phòng có tính tẩy mạnh
+ Nên phơi trong bóng râm để giữ sp bền màu',100,4,1,'27-9-2022',0)
Insert into product values (N'Áo Thun Cổ Tròn Đơn Giản Ver73',227000,'/uploads/product/ao8.png',N'Chất liệu: Cotton Compact 2C
Thành phần: 100% Cotton
- Thân thiện
- Thấm hút thoát ẩm
- Mềm mại
- Kiểm soát mùi
- Điều hòa nhiệt
+ Họa tiết in dẻo
- HDSD:
+ Nên giặt chung với sản phẩm cùng màu
+ Không dùng thuốc tẩy hoặc xà phòng có tính tẩy mạnh
+ Nên phơi trong bóng râm để giữ sp bền màu',100,4,1,'27-9-2022',0)
Insert into product values (N'Áo Polo Đơn Giản Ver46',285000,'/uploads/product/ao9.png',N'Chất liệu: Cotton Compact
Thành phần: 100% Cotton
- Thân thiện
- Thấm hút thoát ẩm
- Mềm mại
- Kiểm soát mùi
- Điều hòa nhiệt
+ Họa tiết in dẻo
- HDSD:
+ Nên giặt chung với sản phẩm cùng màu
+ Không dùng thuốc tẩy hoặc xà phòng có tính tẩy mạnh
+ Nên phơi trong bóng râm để giữ sp bền màu',100,3,1,'27-9-2022',0)
Insert into product values (N'Áo Polo Đơn Giản Ver17',285000,'/uploads/product/ao10.png',N'Chất liệu: Cotton Compact
Thành phần: 100% Cotton
- Thân thiện
- Thấm hút thoát ẩm
- Mềm mại
- Kiểm soát mùi
- Điều hòa nhiệt
+ Họa tiết In dẻo + in nước
- HDSD:
+ Nên giặt chung với sản phẩm cùng màu
+ Không dùng thuốc tẩy hoặc xà phòng có tính tẩy mạnh
+ Nên phơi trong bóng râm để giữ sp bền màu',100,3,1,'27-9-2022',0)
Insert into product values (N'Áo Polo Đơn Giản Ver17',285000,'/uploads/product/ao10.png',N'Chất liệu: Cotton Compact
Thành phần: 100% Cotton
- Thân thiện
- Thấm hút thoát ẩm
- Mềm mại
- Kiểm soát mùi
- Điều hòa nhiệt
+ Họa tiết In dẻo + in nước
- HDSD:
+ Nên giặt chung với sản phẩm cùng màu
+ Không dùng thuốc tẩy hoặc xà phòng có tính tẩy mạnh
+ Nên phơi trong bóng râm để giữ sp bền màu',100,3,1,'27-9-2022',0)
Insert into product values (N'Quần Short Đơn Giản Ver38',287000,'/uploads/product/quan1.png',N'Chất liệu: COTTON DOUBLE FACE
- Vải sợi Cotton được dệt theo "DOUBLE-FACE" có cấu trúc 2 bề mặt giống nhau, có thể sử dụng được cả 2 mặt vải .
Thành phần: 87% Cotton 13% Polyester
- Co giãn
- Độ bền cao	
- Thoáng Khí
- Nhanh khô
+ Họa tiết in dẻo
+ Hai túi bên hông Reverse Coil Zipper (Những chiếc khoá túi này có bề mặt ngoài dẹp, phẳng trong khi răng khoá thì ở trong)',100,6,1,'27-9-2022',0)

Insert into product values (N'Quần Jean Nam Slimfit',425000,'/uploads/product/quan2.png',N'Chất liệu: COTTON DOUBLE FACE
- Vải sợi Cotton được dệt theo "DOUBLE-FACE" có cấu trúc 2 bề mặt giống nhau, có thể sử dụng được cả 2 mặt vải .
Thành phần: 87% Cotton 13% Polyester
- Co giãn
- Độ bền cao	
- Thoáng Khí
- Nhanh khô
+ Họa tiết in dẻo
+ Hai túi bên hông Reverse Coil Zipper (Những chiếc khoá túi này có bề mặt ngoài dẹp, phẳng trong khi răng khoá thì ở trong)',100,9,2,'27-9-2022',0)

Insert into product values (N'Quần Tây Slimfit',420000,'/uploads/product/quan3.png',N'Chất liệu: COTTON DOUBLE FACE
- Vải sợi Cotton được dệt theo "DOUBLE-FACE" có cấu trúc 2 bề mặt giống nhau, có thể sử dụng được cả 2 mặt vải .
Thành phần: 87% Cotton 13% Polyester
- Co giãn
- Độ bền cao	
- Thoáng Khí
- Nhanh khô
+ Họa tiết in dẻo
+ Hai túi bên hông Reverse Coil Zipper (Những chiếc khoá túi này có bề mặt ngoài dẹp, phẳng trong khi răng khoá thì ở trong)',100,7,2,'27-9-2022',0)

Insert into product values (N'Quần Jean Nam Straight',445000,'/uploads/product/quan4.png',N'Chất liệu: COTTON DOUBLE FACE
- Vải sợi Cotton được dệt theo "DOUBLE-FACE" có cấu trúc 2 bề mặt giống nhau, có thể sử dụng được cả 2 mặt vải .
Thành phần: 87% Cotton 13% Polyester
- Co giãn
- Độ bền cao	
- Thoáng Khí
- Nhanh khô
+ Họa tiết in dẻo
+ Hai túi bên hông Reverse Coil Zipper (Những chiếc khoá túi này có bề mặt ngoài dẹp, phẳng trong khi răng khoá thì ở trong)',100,9,3,'27-9-2022',0)

Insert into product values (N'Quần Jean Nam Hero',445000,'/uploads/product/quan5.png',N'Chất liệu: COTTON DOUBLE FACE
- Vải sợi Cotton được dệt theo "DOUBLE-FACE" có cấu trúc 2 bề mặt giống nhau, có thể sử dụng được cả 2 mặt vải .
Thành phần: 87% Cotton 13% Polyester
- Co giãn
- Độ bền cao	
- Thoáng Khí
- Nhanh khô
+ Họa tiết in dẻo
+ Hai túi bên hông Reverse Coil Zipper (Những chiếc khoá túi này có bề mặt ngoài dẹp, phẳng trong khi răng khoá thì ở trong)',100,9,2,'27-9-2022',0)

Insert into product values (N'Quần Jogger Kakki Nam Straight',425000,'/uploads/product/quan6.png',N'Chất liệu: COTTON DOUBLE FACE
- Vải sợi Cotton được dệt theo "DOUBLE-FACE" có cấu trúc 2 bề mặt giống nhau, có thể sử dụng được cả 2 mặt vải .
Thành phần: 87% Cotton 13% Polyester
- Co giãn
- Độ bền cao	
- Thoáng Khí
- Nhanh khô
+ Họa tiết in dẻo
+ Hai túi bên hông Reverse Coil Zipper (Những chiếc khoá túi này có bề mặt ngoài dẹp, phẳng trong khi răng khoá thì ở trong)',100,8,3,'27-9-2022',0)

Insert into product values (N'Áo thun Nam',300000,'/uploads/product/ao11.png',N'Chất liệu: COTTON DOUBLE FACE
- Vải sợi Cotton được dệt theo "DOUBLE-FACE" có cấu trúc 2 bề mặt giống nhau, có thể sử dụng được cả 2 mặt vải .
Thành phần: 87% Cotton 13% Polyester
- Co giãn
- Độ bền cao	
- Thoáng Khí
- Nhanh khô
+ Họa tiết in dẻo
+ Hai túi bên hông Reverse Coil Zipper (Những chiếc khoá túi này có bề mặt ngoài dẹp, phẳng trong khi răng khoá thì ở trong)',100,4,3,'27-9-2022',0)

Insert into product values (N'Áo sơ mi commic cartoon',285000,'/uploads/product/ao12.png',N'Chất liệu: COTTON DOUBLE FACE
- Vải sợi Cotton được dệt theo "DOUBLE-FACE" có cấu trúc 2 bề mặt giống nhau, có thể sử dụng được cả 2 mặt vải .
Thành phần: 87% Cotton 13% Polyester
- Co giãn
- Độ bền cao	
- Thoáng Khí
- Nhanh khô
+ Họa tiết in dẻo
+ Hai túi bên hông Reverse Coil Zipper (Những chiếc khoá túi này có bề mặt ngoài dẹp, phẳng trong khi răng khoá thì ở trong)',100,5,2,'27-9-2022',0)

GO
Create table dbo.[order](
	orderId [int] IDENTITY(1,1) PRIMARY KEY not null,
	[uId] int references [user](uId),
	uName nvarchar(50),
	uPhone char(11),
	uAddress nvarchar(500),
	createAt DATETIME,
	totalPrice float,
)
go

create table dbo.orderdetail(
	id [int] IDENTITY(1,1) PRIMARY KEY not null,
	orderId int references [order](orderId),
	productId int references product(pId),
	[count] int,
	totalPrice float,
	[status] int references OrderStatus(id),
)
GO


create table dbo.cart(
	cartId int identity(1,1) primary key,
	[uId] int references [user](uId),
)
go
Insert into cart values(1)

go
Create trigger trg_cart on [user] after insert as
begin
	Insert into cart(uId)
	SELECT
        i.uId        
    FROM
        inserted i;
End

go
create table dbo.cartItems(
	id int identity(1,1) primary key,
	cartId int references cart(cartId),
	productId int references product(pId),
	[count] int,
	totalPrice float
)
go
Create trigger trg_cartItems on cartItems after insert, update as
begin
	update cartItems
	set totalPrice = [count] *  product.pPrice
	From cartItems join product 
	On cartItems.productId = product.pId
End
go 
Insert into cartItems values(1,1,2,null)
Insert into cartItems values(1,2,1,null)
Insert into cartItems values(1,3,1,null)

go
Create trigger trg_orderItems on orderdetail after insert, update, delete as
begin
	update orderdetail
	set totalPrice = [count] *  product.pPrice
	From orderdetail join product 
	On orderdetail.productId = product.pId;

	update [order]
	set [order].totalPrice = h.tong 
	from (select orderdetail.orderId as id, sum(orderdetail.totalPrice) as tong 
	from [order] join orderdetail
	on [order].orderId = orderdetail.orderId
	where orderdetail.status !=7 or orderdetail.status !=5
	group by orderdetail.orderId) h join inserted i
	on h.id = i.orderId
	where [order].orderId = i.orderId

	update product
	set sold = p.soluong + p.soluong,
	pQuantity = pQuantity - p.soluong
	from (select orderdetail.productId as pid, sum(orderdetail.[count]) as soluong
	from orderdetail join [order]
	on orderdetail.orderId = [order].orderId	
	join inserted i
	on orderdetail.id = i.id
	where orderdetail.status=4
	group by orderdetail.productId) as p 
	where product.pId = p.pid
End



go
Insert into [order] values (1,N'Nguyễn Khắc Dương', '0971616162', 'HCM', '27-11-2020',null)
Insert into [order] values (1,N'Nguyễn Khắc Dương', '0971616162', 'HCM', '27-12-2020',null)
Insert into [order] values (1,N'Nguyễn Khắc Dương', '0971616162', 'HCM', '27-1-2021',null)
Insert into [order] values (1,N'Nguyễn Khắc Dương', '0971616162', 'HCM', '27-2-2021',null)
Insert into [order] values (1,N'Nguyễn Khắc Dương', '0971616162', 'HCM', '27-3-2021',null)
Insert into [order] values (1,N'Nguyễn Khắc Dương', '0971616162', 'HCM', '27-4-2021',null)
Insert into [order] values (1,N'Nguyễn Khắc Dương', '0971616162', 'HCM', '27-5-2021',null)
Insert into [order] values (1,N'Nguyễn Khắc Dương', '0971616162', 'HCM', '27-6-2021',null)
Insert into [order] values (1,N'Nguyễn Khắc Dương', '0971616162', 'HCM', '27-7-2021',null)
Insert into [order] values (1,N'Nguyễn Khắc Dương', '0971616162', 'HCM', '27-8-2021',null)
Insert into [order] values (1,N'Nguyễn Khắc Dương', '0971616162', 'HCM', '27-9-2021',null)
Insert into [order] values (1,N'Nguyễn Khắc Dương', '0971616162', 'HCM', '27-10-2021',null)
Insert into [order] values (1,N'Nguyễn Khắc Dương', '0971616162', 'HCM', '27-11-2021',null)
Insert into [order] values (1,N'Nguyễn Khắc Dương', '0971616162', 'HCM', '27-12-2021',null)
Insert into [order] values (1,N'Nguyễn Khắc Dương', '0971616162', 'HCM', '27-1-2022',null)
Insert into [order] values (1,N'Nguyễn Khắc Dương', '0971616162', 'HCM', '27-2-2022',null)
Insert into [order] values (1,N'Nguyễn Khắc Dương', '0971616162', 'HCM', '27-3-2022',null)
Insert into [order] values (1,N'Nguyễn Khắc Dương', '0971616162', 'HCM', '27-4-2022',null)
Insert into [order] values (1,N'Nguyễn Khắc Dương', '0971616162', 'HCM', '27-5-2022',null)
Insert into [order] values (1,N'Nguyễn Khắc Dương', '0971616162', 'HCM', '27-6-2022',null)
Insert into [order] values (1,N'Nguyễn Khắc Dương', '0971616162', 'HCM', '27-7-2022',null)
Insert into [order] values (1,N'Nguyễn Khắc Dương', '0971616162', 'HCM', '27-8-2022',null)
Insert into [order] values (1,N'Nguyễn Khắc Dương', '0971616162', 'HCM', '27-9-2022',null)
Insert into [order] values (1,N'Nguyễn Khắc Dương', '0971616162', 'HCM', '27-10-2022',null)
Insert into [order] values (1,N'Nguyễn Khắc Dương', '0971616162', 'HCM', '27-11-2022',null)

Insert into orderdetail values (1,1,12,null,4)
Insert into orderdetail values (2,2,15,null,4)
Insert into orderdetail values (3,10,21,null,4)
Insert into orderdetail values (4,11,20,null,4)
Insert into orderdetail values (5,7,22,null,4)
Insert into orderdetail values (6,8,10,null,4)
Insert into orderdetail values (7,12,11,null,4)
Insert into orderdetail values (8,8,12,null,4)
Insert into orderdetail values (9,9,15,null,4)
Insert into orderdetail values (10,2,14,null,4)
Insert into orderdetail values (11,5,13,null,4)
Insert into orderdetail values (12,4,41,null,4)
Insert into orderdetail values (13,3,30,null,4)
Insert into orderdetail values (14,7,25,null,4)
Insert into orderdetail values (15,11,17,null,4)
Insert into orderdetail values (16,12,19,null,4)
Insert into orderdetail values (17,10,22,null,4)
Insert into orderdetail values (18,9,15,null,4)
Insert into orderdetail values (19,1,11,null,4)
Insert into orderdetail values (20,2,25,null,4)
Insert into orderdetail values (21,7,20,null,4)
Insert into orderdetail values (22,1,14,null,4)
Insert into orderdetail values (23,2,19,null,4)
Insert into orderdetail values (24,8,20,null,4)
Insert into orderdetail values (25,9,22,null,4)

Insert into [order] values (2,N'Phan Duy Lâm', '0914141414', 'HCM', '27-9-2022',null)
Insert into [order] values (2,N'Phan Duy Lâm', '0914141414', 'HCM', '28-9-2022',null)
Insert into [order] values (2,N'Phan Duy Lâm', '0914141414', 'HCM', '30-9-2022',null)
Insert into [order] values (2,N'Phan Duy Lâm', '0914141414', 'HCM', '15-10-2022',null)
Insert into [order] values (2,N'Phan Duy Lâm', '0914141414', 'HCM', '17-10-2022',null)
Insert into [order] values (2,N'Phan Duy Lâm', '0914141414', 'HCM', '14-10-2022',null)
Insert into [order] values (2,N'Phan Duy Lâm', '0914141414', 'HCM', '20-10-2022',null)
Insert into [order] values (2,N'Phan Duy Lâm', '0914141414', 'HCM', '26-11-2022',null)
Insert into [order] values (2,N'Phan Duy Lâm', '0914141414', 'HCM', '30-11-2022',null)
Insert into [order] values (2,N'Phan Duy Lâm', '0914141414', 'HCM', '4-12-2022',null)
Insert into [order] values (2,N'Phan Duy Lâm', '0914141414', 'HCM', '13-12-2022',null)


Insert into orderdetail values (26,13,3,null,4)
Insert into orderdetail values (27,15,6,null,4)
Insert into orderdetail values (28,16,8,null,4)
Insert into orderdetail values (29,17,1,null,4)
Insert into orderdetail values (30,13,4,null,4)
Insert into orderdetail values (31,16,25,null,4)
Insert into orderdetail values (32,19,8,null,4)
Insert into orderdetail values (33,15,16,null,4)
Insert into orderdetail values (34,12,9,null,4)
Insert into orderdetail values (35,17,6,null,4)
Insert into orderdetail values (36,18,7,null,4)

Insert into [order] values (2,N'Lê Anh Hùng', '0936363636', 'HCM', '17-9-2022',null)
Insert into [order] values (2,N'Lê Anh Hùng', '0936363636', 'HCM', '21-9-2022',null)
Insert into [order] values (2,N'Lê Anh Hùng', '0936363636', 'HCM', '30-9-2022',null)
Insert into [order] values (2,N'Lê Anh Hùng', '0936363636', 'HCM', '5-10-2022',null)
Insert into [order] values (2,N'Lê Anh Hùng', '0936363636', 'HCM', '11-11-2022',null)
Insert into [order] values (2,N'Lê Anh Hùng', '0936363636', 'HCM', '30-11-2022',null)
Insert into [order] values (2,N'Lê Anh Hùng', '0936363636', 'HCM', '9-12-2022',null)
Insert into [order] values (2,N'Lê Anh Hùng', '0936363636', 'HCM', '20-12-2022',null)

Insert into orderdetail values (37,16,7,null,4)
Insert into orderdetail values (38,13,2,null,4)
Insert into orderdetail values (39,17,8,null,4)
Insert into orderdetail values (40,11,5,null,4)
Insert into orderdetail values (41,11,1,null,4)
Insert into orderdetail values (42,12,12,null,4)
Insert into orderdetail values (43,18,4,null,4)
Insert into orderdetail values (44,5,10,null,4)