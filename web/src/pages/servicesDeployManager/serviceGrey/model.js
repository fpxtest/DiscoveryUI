import { message } from 'antd'

const Model = {
 namespace: 'serviceGray',
 state: {
  // 新建-全局配置
  gobal: {}
 },
 effects: {
  *new({payload}, {call, put}) {
   yield put({
    type: 'changeGobal',
    payload: payload
   })
  },
  *add({ payload }, { call, put, select }) {
   const gobal = yield select(state => state.serviceGray.gobal)
   console.log(gobal)
   let name = payload.arrange.name
   !gobal.arrange && (gobal.arrange = []) 
   if (gobal.subscribeInstanceKey.name == name || gobal.arrange.find(i => i.name == name)) {
    message.error(`${name} 已经有了`)
   } else {
    let _gobal = Object.assign({}, gobal)
    !_gobal.arrange && (_gobal.arrange = []) 
    _gobal.arrange.push(payload.arrange)
    yield put({
     type: 'changeGobal',
     payload: _gobal
    })
   }
  },
  *edit({payload}, {call, put, select}) {
   const gobal = yield select(state => state.serviceGray.gobal)
   let name = payload.arrange.name
   if (gobal.subscribeInstanceKey.name == name) {
    return
   }
   let index = 0
   let _arrange = gobal.arrange.find((i, _index) => {
    if (i.name == name) {
     index = _index
     return true
    } else {
     return false
    }
   })
   if (!_arrange) {
    message.error(`${name} 还没有添加`)
   } else {
    let _gobal = Object.assign({}, gobal)
     _gobal.arrange[index] = payload.arrange
     console.log(_gobal)
     yield put({
      type: 'changeGobal',
      payload: _gobal
     })
   }
  }
 },
 reducers: {
  changeGobal(state, {payload}) {
   return { ...state, gobal: payload}
  }
 }
}
export default Model