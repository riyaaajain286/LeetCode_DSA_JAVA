# Write your MySQL query statement below
SELECT user_id,
name,
mail
FROM Users
WHERE REGEXP_LIKE(
    mail,
     '^[A-Za-z][A-Za-z0-9_.-]*@leetcode[.]com$',
     'c'
     );

-- ^

-- means start of string.

-- [A-Za-z]

-- means first character must be a letter.

-- [A-Za-z0-9_.-]*

-- means after the first letter, we allow:

-- A-Z
-- a-z
-- 0-9
-- _
-- .
-- -

-- and * means zero or more times.

-- Then:

-- @leetcode[.]com

-- means the exact domain @leetcode.com.

-- Finally:

-- $

-- means end of string.

-- So mentally read the whole regex as:

-- Start → first character is a letter → then zero or more allowed characters → exact @leetcode.com → end.