-- 코드를 작성해주세요
SELECT DISTINCT d.ID, d.EMAIL, d.FIRST_NAME, d.LAST_NAME
FROM DEVELOPERS d, SKILLCODES s
WHERE s.CATEGORY = 'Front End' AND d.SKILL_CODE &  s.CODE
ORDER BY d.ID;