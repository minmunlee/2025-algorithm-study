{\rtf1\ansi\ansicpg949\cocoartf2821
\cocoatextscaling0\cocoaplatform0{\fonttbl\f0\fswiss\fcharset0 Helvetica;}
{\colortbl;\red255\green255\blue255;}
{\*\expandedcolortbl;;}
\paperw11900\paperh16840\margl1440\margr1440\vieww11520\viewh8400\viewkind0
\pard\tx720\tx1440\tx2160\tx2880\tx3600\tx4320\tx5040\tx5760\tx6480\tx7200\tx7920\tx8640\pardirnatural\partightenfactor0

\f0\fs24 \cf0 import java.util.Arrays;\
import java.util.PriorityQueue;\
\
class Solution \{\
    public int solution(int[][] jobs) \{\
        int answer = 0;\
\
        Arrays.sort(jobs, ((o1, o2) -> \{\
            if(o1[0] == o2[0]) \{\
                return o1[1] - o2[1];\
            \}\
            return o1[0] - o2[0];\
        \})); // \uc0\u51089 \u50629  \u49884 \u51089  \u49884 \u44036 \u51060  \u48736 \u47480  \u49692 , \u49548 \u50836  \u49884 \u44036 \u51060  \u48736 \u47480  \u49692 \u51004 \u47196  \u51221 \u47148 \
\
        PriorityQueue<int[]> q = new PriorityQueue<>(((o1, o2) -> \{\
            if (o1[1] == o2[1]) \{\
                if (o1[0] == o2[0]) \{\
                    return 0;\
                \}\
                return o1[0] - o2[0];\
            \}\
            return o1[1] - o2[1];\
        \}));\
\
        int done_count = jobs.length, idx = 0, time = 0;\
\
        while (done_count > 0) \{\
            if (q.isEmpty()) \{ // \uc0\u53328 \u44032  \u48708 \u50632 \u51004 \u47732  (\u51089 \u50629 \u54624 \u44172  \u50630 \u51004 \u47732 ) \u49884 \u44036 \u51012  \u46244 \u47196  \u48372 \u45236 \u49436  \u51236  \u47676 \u51200  \u49884 \u51089 \u54624  \u49688  \u51080 \u45716  \u51089 \u50629  \u45824 \u44592  \u53328 \u50640  \u45347 \u44592 \
                time = jobs[idx][0];\
                q.add(jobs[idx++]);\
                continue;\
            \}\
            int[] arr = q.poll(); // \uc0\u45824 \u44592  \u53328 \u50640 \u49436  \u51228 \u51068  \u50864 \u49440 \u49692 \u50948 \u44032  \u45458 \u51008  \u51089 \u50629  \u44732 \u45236 \u44592 \
            time += arr[1]; // \uc0\u51648 \u44552  \u49884 \u44036 \u50640  \u54788 \u51116  \u51089 \u50629  \u49548 \u50836  \u49884 \u44036  \u45908 \u54616 \u44592  == \u45149 \u45208 \u45716  \u49884 \u44036 \
            answer += (time - arr[0]); // \uc0\u51060  \u51089 \u50629 \u51060  \u46308 \u50612 \u50728  \u49884 \u44036 \u44284  \u51089 \u50629 \u51060  \u45149 \u45212  \u51648 \u44552  \u49884 \u44036 \u51032  \u52264  \u44396 \u54616 \u44592  (\u54217 \u44512  \u44396 \u54616 \u44592  \u50857 )\
            done_count--;\
\
            while (true) \{ // \uc0\u54788 \u51116  \u49884 \u44036 \u50640  \u51089 \u50629  \u49884 \u51089 \u54624  \u49688  \u51080 \u45716  \u51089 \u50629 \u46308  \u45824 \u44592  \u53328 \u50640  \u45347 \u51020 \
                if (idx >= jobs.length || time < jobs[idx][0]) \{\
                    break;\
                \}\
\
                q.add(jobs[idx++]);\
            \}\
        \}\
        \
        return answer / jobs.length;\
    \}\
\}}