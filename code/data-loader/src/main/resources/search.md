


## 搜索元数据

| 属性名  |
|---|
| resumeID  |

----------
"_source"：enabled
"store": false
jcseg_search

----------
| 属性名 | 中文解析 | 索引type | 索引index | 搜索type | 搜索 | 备注 |
| ---- | ----- | ----- | ------ | ----- | -- | -- |
| resumeID | 简历ID | long | no |  |  | |
| userID | 用户ID | long | no | 精确匹配 |  | |
| gender | 性别 | short | not_analyzed | 精确匹配 |  | |
| birthDate | 出生日期 | date | not_analyzed | 精确匹配 | "format": "yyyy-MM-dd" | 年龄 |
| joinWorkDate | 工作日期 | date | not_analyzed | 精确匹配 | "format": "yyyy-MM-dd" | 工作经验 |
| education	| 学历 | short | not_analyzed | 精确匹配 | range |  |
| objectvie | 求职意向 | object |  |  |  |  |
| objectvie.jobType | 求职类型 | short | not_analyzed | 精确匹配 |  | 全职/兼职/实习 |
| objectvie.status | 求职状态 | short | not_analyzed | 精确匹配 |  | 目前正在找工作/在职，正考虑换工作 |
| objectvie.industry | 期望行业 | short | not_analyzed | 精确匹配 |  |  |
| objectvie.province | 期望工作（省） | string | not_analyzed | 精确匹配 |  | 名称 |
| objectvie.city | 期望工作（市） | string | not_analyzed | match |  | 名称 |
| objectvie.district | 期望工作（区） | string | not_analyzed | match |  | 名称 |
| objectvie.location | 期望工作城市 | string | not_analyzed | match |  | 编码 |
| objectvie.salary | 期望薪资范围 | short | not_analyzed | 精确匹配 |  |  |
| objectvie.category | 期望职能 | string | not_analyzed | match |  | 三级职能名称，可多选 |
| available | 简历隐藏状态 | short | not_analyzed | 精确匹配 |  | 是否可以被搜索到 |
| refreshDate | 简历更新日期 | date | not_analyzed | 精确匹配 | "format": "yyyy-MM-dd" | 三天内/一周内 |
| identityStatus | 身份状态 | short | not_analyzed | 精确匹配 |  | 求职者身份正常，招聘者身份关闭等 |
| name | 求职者姓名 | string | analyzed | 全文检索 |  |  |
| workExp | 工作经历 | nested |  |  |  |  | 
| workExp.company | 公司 | object |  |  |  |  |
| workExp.company.fullName | 全称 | string | analyzed | 全文检索 |  |  |
| workExp.company.shortName | 简称 | string | analyzed | 全文检索 |  | 目前还没有 |
| workExp.company.category | 三级职能名称 | string | not_analyzed | match |  |  |
| workExp.position | 职位名称 | string | analyzed | 全文检索 |  |  |
| workExp.desc | 职位描述 | string | analyzed | 全文检索 |  |  |
| workExp.workDesc | 工作内容 | string | analyzed | 全文检索 |  |  |
| eduExp | 教育经历 | object |  |  |  |  |
| eduExp.school | 学校 | string | analyzed | 全文检索 |  |  |
| eduExp.major | 专业 | string | analyzed | 全文检索 |  |  |
| registerDate | 用户注册日期 | date | no | sort | "format": "yyyy-MM-dd" | 排序用 |
| lastLoginDate | 用户最后登录日期 | date | no | sort | "format": "yyyy-MM-dd" | 排序用 |
| complete | 简历完整程度 | short | no | sort | 1-100 | 排序用 |
| major | 专业 | string | analyzed | match |  | 目前还没有 |
| unifyEnroll | 是否统招 | boolean | no | 精确匹配 |  | 目前还没有 |

---
