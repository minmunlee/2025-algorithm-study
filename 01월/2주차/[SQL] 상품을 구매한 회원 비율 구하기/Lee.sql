{\rtf1\ansi\ansicpg949\cocoartf2821
\cocoatextscaling0\cocoaplatform0{\fonttbl\f0\fswiss\fcharset0 Helvetica;}
{\colortbl;\red255\green255\blue255;}
{\*\expandedcolortbl;;}
\paperw11900\paperh16840\margl1440\margr1440\vieww11520\viewh8400\viewkind0
\pard\tx720\tx1440\tx2160\tx2880\tx3600\tx4320\tx5040\tx5760\tx6480\tx7200\tx7920\tx8640\pardirnatural\partightenfactor0

\f0\fs24 \cf0 SELECT YEAR(SALES_DATE) YEAR, \
MONTH(SALES_DATE) MONTH, \
COUNT(DISTINCT(OS.USER_ID)) PURCHASED_USERS, \
ROUND(COUNT(DISTINCT(OS.USER_ID)) / (SELECT COUNT(USER_ID) C \
                                     FROM USER_INFO \
                                     WHERE JOINED LIKE '2021-%'), 1) PUCHASED_RATIO\
FROM ONLINE_SALE OS INNER JOIN USER_INFO UI\
ON OS.USER_ID = UI.USER_ID AND JOINED LIKE '2021-%'\
GROUP BY YEAR, MONTH\
ORDER BY YEAR, MONTH}