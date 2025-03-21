-- 코드를 작성해주세요
SELECT 
CASE 
    WHEN ((SELECT SUM(CODE) FROM SKILLCODES WHERE CATEGORY = 'Front End') & SKILL_CODE) 
         AND ((SELECT CODE FROM SKILLCODES WHERE NAME = 'Python') & SKILL_CODE) THEN 'A'
    WHEN (SELECT CODE FROM SKILLCODES WHERE NAME = 'C#') & SKILL_CODE THEN 'B'
    WHEN (SELECT SUM(CODE) FROM SKILLCODES WHERE CATEGORY = 'Front End') & SKILL_CODE THEN 'C' 
END GRADE, ID, EMAIL
FROM DEVELOPERS 
HAVING GRADE IS NOT NULL
ORDER BY GRADE, ID