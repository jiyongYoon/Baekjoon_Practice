SELECT DISTINCT I.ITEM_ID, I.ITEM_NAME, I.RARITY
FROM ITEM_INFO I
WHERE I.ITEM_ID IN (
        SELECT IT.ITEM_ID
        FROM ITEM_TREE IT
        WHERE IT.PARENT_ITEM_ID IN (
                SELECT ITEM_ID
                FROM ITEM_INFO
                WHERE RARITY = 'RARE'
        )
    )
ORDER BY I.ITEM_ID DESC