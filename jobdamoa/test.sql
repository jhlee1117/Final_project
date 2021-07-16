select * from favorites where ann_num in (select ann_num from announcement where ann_del = 'y');

select ann_num from announcement where ann_del = 'y';

select * from favorites where 12 in (select ann_num from announcement where ann_del = 'y');

select * from favorites;