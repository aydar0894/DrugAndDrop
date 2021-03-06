CREATE TABLE Category(
	[id] [int] IDENTITY(1,1) NOT NULL,
	[capacity] [int] NOT NULL,
	[numOfrooms] [int] NOT NULL,
	[breakfast] [int] NOT NULL,
	[name] [varchar](15) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]


CREATE TABLE Position(
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [varchar](15) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]


CREATE TABLE Hotels(
	[id] [int] IDENTITY(1,1) NOT NULL,
	[hotelLocation] [varchar](100) NULL,
	[name] [varchar](100) NULL,
	[hotelCategory] [int] CHECK  (([hotelCategory]>=(1) AND [hotelCategory]<=(5))),
	[pictUrl] [varchar](100) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY],
UNIQUE NONCLUSTERED 
(
	[hotelLocation] ASC,
	[name] ASC,
	[hotelCategory] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

CREATE TABLE Staff(
	[id] [int] IDENTITY(1,1) NOT NULL,
	[hId] [int] NULL,
	[name] [varchar](100) NULL,
	[salary] [int] NOT NULL,
	[dateOfBirth] [datetime] NOT NULL,
	[position] [int] NULL,
	[phone] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]



ALTER TABLE Staff  WITH NOCHECK ADD FOREIGN KEY([hId])
REFERENCES Hotels ([id])
ON DELETE CASCADE

CREATE TABLE HotelNumbers(
	[id] [int] IDENTITY(1,1) NOT NULL,
	[number] [int] NOT NULL,
	[price] [float] NULL,
	[hId] [int] NULL,
	[catNum] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]


ALTER TABLE HotelNumbers  WITH CHECK ADD FOREIGN KEY([catNum])
REFERENCES Category ([id])
ON DELETE SET DEFAULT

ALTER TABLE HotelNumbers WITH NOCHECK ADD FOREIGN KEY([hId])
REFERENCES Hotels ([id])
ON DELETE CASCADE

CREATE TABLE NumberState(
	[numId] [int] NULL,
	[staffId] [int] NULL,
	[numState] [int] NOT NULL
) ON [PRIMARY]



ALTER TABLE NumberState  WITH CHECK ADD FOREIGN KEY([numId])
REFERENCES HotelNumbers ([id])
ON DELETE CASCADE


ALTER TABLE NumberState  WITH CHECK ADD FOREIGN KEY([staffId])
REFERENCES Staff ([id])

CREATE TABLE Customers(
	[id] [int] IDENTITY(1,1) NOT NULL,
	[custName] [varchar](35) NOT NULL,
	[dateOfBirth] [datetime] NOT NULL,
	[gender] [int] NOT NULL,
	[paymentForm] [varchar](10) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]


CREATE TABLE Rent(
	[id] [int] IDENTITY(1,1) NOT NULL,
	[hId] [int] NULL,
	[totalPrice] [float] NOT NULL,
	[nId] [int] NULL,
	[cId] [int] NULL,
	[dateOfDeparture] [datetime] NULL,
	[arrivalDate] [datetime] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]



ALTER TABLE Rent WITH CHECK ADD FOREIGN KEY([cId])
REFERENCES Customers ([id])

ALTER TABLE Rent  WITH NOCHECK ADD FOREIGN KEY([hId])
REFERENCES Hotels ([id])
ON DELETE CASCADE


ALTER TABLE Rent  WITH CHECK ADD FOREIGN KEY([nId])
REFERENCES HotelNumbers ([id])


CREATE TABLE users(
	[id] [int] IDENTITY(1,1) NOT NULL,
	[username] [varchar](100) NOT NULL,
	[pass] [varchar](100) NOT NULL,
	[cId] [int] NULL,
	[email] [varchar](100) NULL,
	[phone] [varchar](100) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]



ALTER TABLE users  WITH CHECK ADD FOREIGN KEY([cId])
REFERENCES Customers ([id])

