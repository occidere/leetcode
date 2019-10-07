# @param {String} path
# @return {String}
def simplify_path(path)
  stk = []
  path.split('/').reject { |_| _ == '.' or _ == '' }.each do |k|
    k == '..' ? stk.pop : stk << k
  end
  '/' + stk.join('/')
end