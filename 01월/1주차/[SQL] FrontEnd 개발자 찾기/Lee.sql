SELECT DISTINCT ID, EMAIL, FIRST_NAME, LAST_NAME
FROM DEVELOPERS D, SKILLCODES S
WHERE CATEGORY = 'Front End' AND SKILL_CODE & CODE
ORDER BY ID