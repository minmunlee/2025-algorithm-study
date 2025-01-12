{\rtf1\ansi\ansicpg949\cocoartf2821
\cocoatextscaling0\cocoaplatform0{\fonttbl\f0\fswiss\fcharset0 Helvetica;}
{\colortbl;\red255\green255\blue255;}
{\*\expandedcolortbl;;}
\paperw11900\paperh16840\margl1440\margr1440\vieww11520\viewh8400\viewkind0
\pard\tx720\tx1440\tx2160\tx2880\tx3600\tx4320\tx5040\tx5760\tx6480\tx7200\tx7920\tx8640\pardirnatural\partightenfactor0

\f0\fs24 \cf0 import java.io.BufferedReader;\
import java.io.IOException;\
import java.io.InputStreamReader;\
import java.util.Arrays;\
import java.util.PriorityQueue;\
\
public class Main \{\
    public static void main(String[] args) throws IOException \{\
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));\
        int N = Integer.parseInt(br.readLine());\
        int[][] lessons = new int[N][3];\
\
        for (int i = 0; i < N; i++) \{\
            lessons[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();\
        \}\
\
        Arrays.sort(lessons, (o1, o2) -> \{ // \uc0\u48176 \u50676 \u51008  \u49884 \u51089 \u49884 \u44036 \u51060  \u48736 \u47480  \u49692 \u51004 \u47196  \u51221 \u47148 \
            if (o1[1] == o2[1]) \{\
                return o1[2] - o2[2];\
            \}\
            return o1[1] - o2[1];\
        \});\
\
        PriorityQueue<int[]> q = new PriorityQueue<>(((o1, o2) -> \{ // \uc0\u53328 \u45716  \u51333 \u47308 \u49884 \u44036 \u51060  \u48736 \u47480  \u49692 \u51004 \u47196  \u51221 \u47148 \u46104 \u46020 \u47197 \
            if (o1[2] == o2[2]) \{\
                return o1[1] - o2[1];\
            \}\
            return o1[2] - o2[2];\
        \}));\
\
        int result = 1;\
\
        for (int i = 0; i < N; i++) \{\
            if (q.isEmpty()) \{\
                q.add(lessons[i]);\
                continue;\
            \}\
            int[] lesson = q.poll();\
            if (lesson[2] > lessons[i][1]) \{ // \uc0\u48712  \u44053 \u51032 \u49892  \u50630 \u51020 \
                q.add(lesson);\
                result++;\
            \}\
            q.add(lessons[i]);\
        \}\
\
        System.out.print(result);\
    \}\
\}}