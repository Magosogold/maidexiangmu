export function isAuth(tableName, key) {
  let role = localStorage.getItem("UserTableName");
  let menus = [{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-shop","buttons":["新增","查看","修改","删除","审核"],"menu":"招标单位","menuJump":"列表","tableName":"zhaobiaodanwei"}],"menu":"招标单位管理"},{"child":[{"appFrontIcon":"cuIcon-form","buttons":["新增","查看","修改","删除"],"menu":"评标专家","menuJump":"列表","tableName":"pingbiaozhuanjia"}],"menu":"评标专家管理"},{"child":[{"appFrontIcon":"cuIcon-phone","buttons":["新增","查看","修改","删除"],"menu":"投标单位","menuJump":"列表","tableName":"toubiaodanwei"}],"menu":"投标单位管理"},{"child":[{"appFrontIcon":"cuIcon-present","buttons":["查看","修改","删除"],"menu":"招标项目","menuJump":"列表","tableName":"zhaobiaoxiangmu"}],"menu":"招标项目管理"},{"child":[{"appFrontIcon":"cuIcon-present","buttons":["查看","修改","删除"],"menu":"投标记录","menuJump":"列表","tableName":"toubiaojilu"}],"menu":"投标记录管理"},{"child":[{"appFrontIcon":"cuIcon-explore","buttons":["查看","修改","删除"],"menu":"评标记录","menuJump":"列表","tableName":"pingbiaojilu"}],"menu":"评标记录管理"},{"child":[{"appFrontIcon":"cuIcon-medal","buttons":["查看","修改","删除"],"menu":"归档保存","menuJump":"列表","tableName":"guidangbaocun"}],"menu":"归档保存管理"},{"child":[{"appFrontIcon":"cuIcon-brand","buttons":["查看","修改"],"menu":"系统简介","tableName":"systemintro"},{"appFrontIcon":"cuIcon-full","buttons":["查看","修改"],"menu":"轮播图管理","tableName":"config"},{"appFrontIcon":"cuIcon-news","buttons":["新增","查看","修改","删除"],"menu":"公告信息","tableName":"news"},{"appFrontIcon":"cuIcon-full","buttons":["查看","修改"],"menu":"关于我们","tableName":"aboutus"}],"menu":"系统管理"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-goodsnew","buttons":["查看","投标"],"menu":"招标项目列表","menuJump":"列表","tableName":"zhaobiaoxiangmu"}],"menu":"招标项目模块"}],"hasBackLogin":"是","hasBackRegister":"否","hasFrontLogin":"否","hasFrontRegister":"否","roleName":"管理员","tableName":"users"},{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-present","buttons":["新增","查看","修改","删除"],"menu":"招标项目","menuJump":"列表","tableName":"zhaobiaoxiangmu"}],"menu":"招标项目管理"},{"child":[{"appFrontIcon":"cuIcon-present","buttons":["查看"],"menu":"投标记录","menuJump":"列表","tableName":"toubiaojilu"}],"menu":"投标记录管理"},{"child":[{"appFrontIcon":"cuIcon-explore","buttons":["查看","归档"],"menu":"评标记录","menuJump":"列表","tableName":"pingbiaojilu"}],"menu":"评标记录管理"},{"child":[{"appFrontIcon":"cuIcon-medal","buttons":["查看"],"menu":"归档保存","menuJump":"列表","tableName":"guidangbaocun"}],"menu":"归档保存管理"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-goodsnew","buttons":["查看","投标"],"menu":"招标项目列表","menuJump":"列表","tableName":"zhaobiaoxiangmu"}],"menu":"招标项目模块"}],"hasBackLogin":"是","hasBackRegister":"是","hasFrontLogin":"否","hasFrontRegister":"否","roleName":"招标单位","tableName":"zhaobiaodanwei"},{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-present","buttons":["查看","审核"],"menu":"招标项目","menuJump":"列表","tableName":"zhaobiaoxiangmu"}],"menu":"招标项目管理"},{"child":[{"appFrontIcon":"cuIcon-present","buttons":["查看","审核","专家评标"],"menu":"投标记录","menuJump":"列表","tableName":"toubiaojilu"}],"menu":"投标记录管理"},{"child":[{"appFrontIcon":"cuIcon-explore","buttons":["查看","修改"],"menu":"评标记录","menuJump":"列表","tableName":"pingbiaojilu"}],"menu":"评标记录管理"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-goodsnew","buttons":["查看","投标"],"menu":"招标项目列表","menuJump":"列表","tableName":"zhaobiaoxiangmu"}],"menu":"招标项目模块"}],"hasBackLogin":"是","hasBackRegister":"否","hasFrontLogin":"否","hasFrontRegister":"否","roleName":"评标专家","tableName":"pingbiaozhuanjia"},{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-present","buttons":["查看"],"menu":"投标记录","menuJump":"列表","tableName":"toubiaojilu"}],"menu":"投标记录管理"},{"child":[{"appFrontIcon":"cuIcon-explore","buttons":["查看"],"menu":"评标记录","menuJump":"列表","tableName":"pingbiaojilu"}],"menu":"评标记录管理"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-goodsnew","buttons":["查看","投标"],"menu":"招标项目列表","menuJump":"列表","tableName":"zhaobiaoxiangmu"}],"menu":"招标项目模块"}],"hasBackLogin":"是","hasBackRegister":"否","hasFrontLogin":"是","hasFrontRegister":"是","roleName":"投标单位","tableName":"toubiaodanwei"}];
  for(let i=0;i<menus.length;i++){
    if(menus[i].tableName==role){
      for(let j=0;j<menus[i].frontMenu.length;j++){
          for(let k=0;k<menus[i].frontMenu[j].child.length;k++){
            if(tableName==menus[i].frontMenu[j].child[k].tableName){
              let buttons = menus[i].frontMenu[j].child[k].buttons.join(',');
              return buttons.indexOf(key) !== -1 || false
            }
          }
      }
    }
  }
  return false;
}

/**
 *  * 获取当前时间（yyyy-MM-dd hh:mm:ss）
 *   */
export function getCurDateTime() {
    let currentTime = new Date(),
    year = currentTime.getFullYear(),
    month = currentTime.getMonth() + 1 < 10 ? '0' + (currentTime.getMonth() + 1) : currentTime.getMonth() + 1,
    day = currentTime.getDate() < 10 ? '0' + currentTime.getDate() : currentTime.getDate(),
    hour = currentTime.getHours(),
    minute = currentTime.getMinutes(),
    second = currentTime.getSeconds();
    return year + "-" + month + "-" + day + " " +hour +":" +minute+":"+second;
}

/**
 *  * 获取当前日期（yyyy-MM-dd）
 *   */
export function getCurDate() {
    let currentTime = new Date(),
    year = currentTime.getFullYear(),
    month = currentTime.getMonth() + 1 < 10 ? '0' + (currentTime.getMonth() + 1) : currentTime.getMonth() + 1,
    day = currentTime.getDate() < 10 ? '0' + currentTime.getDate() : currentTime.getDate();
    return year + "-" + month + "-" + day;
}
